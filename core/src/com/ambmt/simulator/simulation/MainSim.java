package com.ambmt.simulator.simulation;

import com.ambmt.simulator.BaseballSim;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainSim {

    private int runs;
    private boolean gameActive;
    private List<Boolean> templateList = new ArrayList<>();
    private TempSim tempSim;
    private int atBatCount = 1;
    private Random random;
    private int outs = 0;
    private int innings = 0;

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

        while(!gameActive){
            List<Boolean> runners= newInning();
            int result;
            int strikes = 0;

            do{
                result = tempSim.calculatePitchOutcome(1,false,"batter",20,0,random);
                if(result == 1){
                    strikes++;
                }
            }while (result !=3 && strikes <= 2);

            if(result == 3){
                int hitResult = generateRandomHit();
            }
            if (strikes == 3){
                outs++;
            }
            if (outs >= 3){

            }


        }
    }

    // Using https://cran.r-project.org/web/packages/Lahman/vignettes/hits-by-type.html to determine the probability of outcomes. gen 1-100 number.
    // 1- 63 = Single
    // 63-80 = Double
    // 80 - 95 = Homerun
    // 95 - 100 = Triple
    private int generateRandomHit(){
        int hit = random.nextInt(100) + 1;
        if (hit <= 63){
            return 1;
        }
        if(hit <= 80){
            return 2;
        }
        if(hit <= 95){
            return 4;
        }
        else{
            return 3;
        }


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

    private void callUpdate(){

    }

}
