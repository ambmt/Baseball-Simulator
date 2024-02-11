package com.ambmt.simulator.simulation;

import com.ambmt.simulator.players.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainSim {

    private int runs;
    private boolean gameActive = true;
    private List<Boolean> templateList = new ArrayList<>();
    private TempSim tempSim;
    private int atBatCount = 1;
    private Random random;
    private int outs = 0;
    private int innings = 0;
    private Team homeTeam;
    private Team awayTeam;
    private int homeIndex;
    private int awayIndex;
    private String edgePos;

    public void MainSim(){
        random = new Random();
        templateList.add(0, false);
        templateList.add(1, false);
        templateList.add(2, false);
        templateList.add(3, false);
        templateList.add(4, false);
        tempSim = new TempSim();
        this.outs = 0;
        this.innings = 0;

    }
    public List<Boolean> newInning(){
        List<Boolean> runners = new ArrayList<>();
        runners.add(0,true); // Home - therefore this has to be true as a batter always has to be at the plate
        runners.add(1,false); // First
        runners.add(2,false); // Second
        runners.add(3, false); // Thirdv
        runners.add(4, false); // A runner has scored
        return runners;
    }

    public void startGame(){
        List<Boolean> runners= newInning();
        TeamBuilder tb = new TeamBuilder();
        tb.importJSON(0,0);
        homeTeam = tb.homeTeam;
        awayTeam = tb.awayTeam;
        boolean homeActive = false;
        Team activeTeam;
        while(gameActive){
            int result;
            int strikes = 0;
            newAb(runners);
            int newIndex;
            Pitcher pitcher;
            Batter batter;
            if(homeActive){
                pitcher = (Pitcher) awayTeam.getPitchers().get(0);
                newIndex = homeIndex;
                batter = (Batter) homeTeam.getBatters().get(newIndex);
            }
            else{
                pitcher = (Pitcher) homeTeam.getPitchers().get(0);
                newIndex = awayIndex;
                batter = (Batter) awayTeam.getBatters().get(newIndex);
            }
            int margin = calculateMargin(batter, pitcher);
            if (margin > 0){
                edgePos = "batter";
            }
            else{
                // Set edge for pitcher and make the number positive now.
                edgePos = "pitcher";
                margin *= -1;
            }
            do{
                result = tempSim.calculatePitchOutcome(1,false,edgePos,margin,0,random);
                if(result == 1){
                    strikes++;
                }
            }while (result !=3 && strikes <= 2);
            if(result == 3){
                    if(random.nextInt(1000)+ 1 <= 248 ){ // This is the average in the mlb. The margin is already used in the simulation code, therefore I decided to use this
                        runners = generateRandomHit(runners, batter,pitcher);
                    }
                    else{
                        outs++;
                        Out(runners, batter, outs);
                    }
            }
            if (strikes == 3){
                outs++;
                strikeOut(batter,pitcher);
            }
            if (outs >= 3){
                runners = newInning();
                innings++;
                outs = 0;
                if(newIndex == 7){
                    // Resetting the lineup
                    if(homeActive){
                        homeIndex = newIndex;
                    }
                    else{
                        awayIndex = newIndex;
                    }
                }
                homeActive = !homeActive;

            }
            // Temp sim
            if (innings > 3){
                gameActive = false;
            }



        }
    }

    // Using https://cran.r-project.org/web/packages/Lahman/vignettes/hits-by-type.html to determine the probability of outcomes. gen 1-100 number.
    // 1- 63 = Single
    // 63-80 = Double
    // 80 - 95 = Homerun
    // 95 - 100 = Triple
    private List<Boolean> generateRandomHit(List<Boolean> runners, Batter batter, Pitcher pitcher){
        int hit = random.nextInt(100) + 1;
        if (hit <= 63){
            runners = Single(runners);
            callUpdate(batter.getName() + " singles off " + pitcher.getName());
            return runners;
        }
        if(hit <= 80){
            runners = Double(runners);
            callUpdate(batter.getName() + " doubles off " + pitcher.getName());
            return runners;
        }
        if(hit <= 95){
            Homerun(runners);
            callUpdate(batter.getName() + " hits a homerun off " + pitcher.getName());
            return runners;
        }
        else{
            callUpdate(batter.getName() + " triples off " + pitcher.getName());
            runners = Triple(runners);

        }
        return runners;


    }


    private List<Boolean> Single(List<Boolean> runners){
        List<Boolean> tempList = templateList;
        for (int i = 0; i < runners.size() - 1; i++){
            if(runners.get(i)) {
                int temp = i + 1;
                if (temp >= 4) {
                    runs += 1;
                }else{
                    tempList.set(temp, true);
                }
            }

        }
        return tempList;

    }
    private List<Boolean> Double(List<Boolean> runners){
        List<Boolean> tempList = templateList;
        for (int i = 0; i< runners.size(); i++){
            if(runners.get(i)) {
                int temp = i + 2;
                if (temp >= 4) {
                    runs += 1;
                }
                else {
                    tempList.set(temp, true);
                }
            }

        }
        return tempList;

    }
    private List<Boolean> Triple(List<Boolean> runners){
        List<Boolean> tempList = templateList;
        for (int i = 0; i< runners.size(); i++){
            if(runners.get(i)) {
                int temp = i + 3;
                if (temp >= 4) {
                    runs += 1;
                }else {
                    tempList.set(temp, true);
                }
                runners.set(i, false);

            }

        }
        return tempList;

    }
    private void Homerun(List<Boolean> runners){
        for(int i = 0; i< runners.size(); i++){
            if(runners.get(i)){
                runs += 1;
                runners.set(i, false);
            }
        }
    }
    // Using https://library.fangraphs.com/pitching/batted-ball/, I can determine what the league average is and therefore what the outcome will be
    private void Out(List<Boolean> runners, Batter player, int outs){
        int index = random.nextInt(100 + 1);
        if (index <= 21){
            // Linedrive
            callUpdate(player.getName() + " lines out, " + outs + " down.");
            return;
        }
        if( index <= 65){
            callUpdate(player.getName() + " grounds out, " + outs + " down.");
            return;
        }
        else{
            callUpdate(player.getName() + " flies, " + outs + " down.");
        }
    }
    private void strikeOut(Batter batter, Pitcher pitcher){
        callUpdate(batter.getName() + " strikes out against " + pitcher.getName());
    }

    private void callUpdate(String event){
        System.out.println(event);
    }

    private List<Boolean> newAb(List<Boolean> runners){
        runners.set(0, true);
        return runners;
    }

    private int calculateMargin(Batter batter, Pitcher pitcher){
        Integer margin = Math.floorDiv(Integer.parseInt(batter.getOnBasePercentage()) - pitcher.getEarnedRunAvgPlus() , 2);
        return margin;
    }
    // If it returns negative, its a pitcher advantage, if positive,batter

}


