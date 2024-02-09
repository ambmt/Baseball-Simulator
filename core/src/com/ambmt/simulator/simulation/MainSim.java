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

    public void MainSim(){
        random = new Random();
        templateList.add(0, false);
        templateList.add(1, false);
        templateList.add(2, false);
        templateList.add(3, false);
        templateList.add(4, false);
        tempSim = new TempSim();
    }
    public void newInning(){
        List<Boolean> runners = new ArrayList<>();
        runners.add(0,true); // Home - therefore this has to be true as a batter always has to be at the plate
        runners.add(1,false); // First
        runners.add(2,false); // Second
        runners.add(3, false); // Thirdv
        runners.add(4, false); // A runner has scored
    }

    public void startGame(){
        newInning();

        while(!gameActive){
            int sim = tempSim.calculatePitchOutcome(atBatCount, false,"Pitcher", 10, 0, random);
            System.out.println(sim);
            gameActive = true;

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
