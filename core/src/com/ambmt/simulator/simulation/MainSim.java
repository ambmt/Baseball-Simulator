package com.ambmt.simulator.simulation;

import java.util.ArrayList;
import java.util.List;

public class MainSim {

    private int runs;
    private List<Boolean> templateList = new ArrayList<>();

    public void MainSim(){
        templateList.add(0, false);
        templateList.add(1, false);
        templateList.add(2, false);
        templateList.add(3, false);
        templateList.add(4, false);
    }
    public void runSim(){
        List<Boolean> runners = new ArrayList<>();
        runners.add(0,true); // Home - therefore this has to be true as a batter always has to be at the plate
        runners.add(1,true); // First
        runners.add(2,false); // Second
        runners.add(3, false); // Third
        runners.add(4, false); // A runner has scored
        List<Boolean> newRunners = Triple(runners);
        System.out.println(newRunners);
        System.out.println(runs);
        // possibly a list containing true or false in each element. I
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
