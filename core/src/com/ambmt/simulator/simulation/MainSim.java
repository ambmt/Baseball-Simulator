package com.ambmt.simulator.simulation;

import com.ambmt.simulator.players.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainSim {

    private int runs;
    private boolean gameActive = true;
    private List<Boolean> templateList = new ArrayList<>();
    private TempSim tempSim;
    private boolean[] runners;
    private Random random;
    private int outs = 0;
    private int innings = 0;
    private Team homeTeam;
    private Team awayTeam;
    private int homeIndex;
    private int awayIndex;
    private String edgePos;
    private int homeScore;
    private int awayScore;

    public void MainSim(){
        random = new Random();
        tempSim = new TempSim();
        this.outs = 0;
        this.innings = 0;

    }
    public void startGame(){
        TeamBuilder tb = new TeamBuilder();
        tb.importJSON(0,0);
        homeTeam = tb.homeTeam;
        awayTeam = tb.awayTeam;
        runners = new boolean[4];
        boolean homeActive = false;
        Team activeTeam;
        while(gameActive){
            int result;
            int strikes = 0;
            playerOnBase();
            int newIndex;
            Pitcher pitcher;
            Batter batter;

            int pitchCount;
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
            pitchCount = 1;
            do{
                result = tempSim.calculatePitchOutcome(pitchCount,false,edgePos,margin,0,random);
                pitchCount++;
                if(result == 1){
                    strikes++;
                }
            }while (result !=3 && strikes <= 2);
            newIndex++;
            System.out.println(newIndex);
            if(result == 3){
                    if(random.nextInt(1000)+ 1 <= 248 ){ // This is the average in the mlb. The margin is already used in the simulation code, therefore I decided to use this
                        generateRandomHit(batter,pitcher);
                    }
                    else{
                        outs++;
                        Out(batter, outs);
                    }
            }
            if (strikes == 3){
                outs++;
                strikeOut(batter,pitcher, outs);
            }
            if(newIndex >= 8){
                // Resetting the lineup
                newIndex = 0;
            }
            if (outs >= 3){
                System.out.println("Home: " +homeScore);
                System.out.println("Away: " + awayScore);
                clearBases();
                if(homeActive){
                    homeScore += runs;
                    runs = 0;
                }
                else{
                    awayScore += runs;
                    runs = 0;
                }
                System.out.println(Arrays.toString(runners));
                // A new innning should only be called when the home team has just batted. This being called all the time shortened the game significantly
                if(homeActive){
                    innings++;
                }
                outs = 0;
                homeActive = !homeActive;
            }
            if(homeActive){
                homeIndex = newIndex;
            }
            else{
                awayIndex = newIndex;
            }
            // Temp sim
            if (innings > 8){
                gameActive = false;
                System.out.println(homeScore + " score for the home team");
                System.out.println(awayScore + " score for the away team");
            }

        }
    }

    // Using https://cran.r-project.org/web/packages/Lahman/vignettes/hits-by-type.html to determine the probability of outcomes. gen 1-100 number.
    // 1- 63 = Single
    // 63-80 = Double
    // 80 - 95 = Homerun
    // 95 - 100 = Triple
    private void generateRandomHit(Batter batter, Pitcher pitcher){
        int hit = random.nextInt(100) + 1;
        if (hit <= 63){
            hitSingle();
            System.out.println(Arrays.toString(runners) + " single ");
            callUpdate(batter.getName() + " singles off " + pitcher.getName());
        }
        if(hit <= 80){
            hitDouble();
            callUpdate(batter.getName() + " doubles off " + pitcher.getName());
        }
        if(hit <= 95){
            hitHomeRun();
            System.out.println(Arrays.toString(runners) + " homerun");
            callUpdate(batter.getName() + " hits a homerun off " + pitcher.getName());
        }
        else{
            callUpdate(batter.getName() + " triples off " + pitcher.getName());
            hitTriple();
            System.out.println(Arrays.toString(runners) + " triple");

        }


    }

    // Using https://library.fangraphs.com/pitching/batted-ball/, I can determine what the league average is and therefore what the outcome will be
    private void Out(Batter player, int outs){
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
    private void strikeOut(Batter batter, Pitcher pitcher, int outs){
        callUpdate(batter.getName() + " strikes out against " + pitcher.getName() + "," + outs + " outs.");
    }

    private void callUpdate(String event){
        System.out.println(event);
    }

    private int calculateMargin(Batter batter, Pitcher pitcher){
        return Math.floorDiv(Integer.parseInt(batter.getOnBasePercentage()) - pitcher.getEarnedRunAvgPlus() , 2);
    }
    // If it returns negative, its a pitcher advantage, if positive,batter



    public int getRuns() {
        return runs;
    }

    public void hitSingle() {
        moveRunners(1);
    }

    public void hitDouble() {
        moveRunners(2);
    }

    public void hitTriple() {
        moveRunners(3);
    }

    public void hitHomeRun() {
        moveRunners(4);
    }

    private void moveRunners(int basesToAdvance) {
        // Move runners
        for (int i = runners.length - 1; i >= 0; i--) {
            if (runners[i]) {
                if (i + basesToAdvance >= runners.length) {
                    // A runner crosses home plate and scores a run
                    runs++;
                } else {
                    runners[i + basesToAdvance] = true;
                }
                runners[i] = false;
            }
        }
    }

    private void clearBases() {
        for (int i = 0; i < runners.length; i++) {
            runners[i] = false;
        }
    }

    public void playerOnBase() {
        // Batter (home plate)
        runners[0] = true;
    }

    public void printBaseStatus() {
        System.out.println("Bases: " + runners[0] + " " + runners[1] + " " + runners[2] + " " + runners[3]);
        System.out.println("Runs: " + runs);
    }

}


