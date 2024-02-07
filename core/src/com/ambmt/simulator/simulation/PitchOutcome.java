package com.ambmt.simulator.simulation;

import java.util.List;

public class PitchOutcome {
    //REMEMBER THIS WONT WORK AS RUNNERS WONT BE CLEARED. MAKE THIS AN ERROR AND THEN DOCUMENT IT

    private static void Single(List<Integer> runners, int runs){
        for (int i = 0; i< runners.size(); i++){
            int num = runners.get(i);
            num+= 1;
            if (num >= 4){
                runs += 1;
            }
            runners.set(i, num);
        }

    }
    private static void Double(List<Integer> runners, int runs){
        for (int i = 0; i< runners.size(); i++){
            int num = runners.get(i);
            num+= 1;
            if (num >= 4){
                runs += 2;
            }
            runners.set(i, num);
        }

    }
    private static void Triple(List<Integer> runners, int runs){
        for (int i = 0; i< runners.size(); i++){
            int num = runners.get(i);
            num+= 1;
            if (num >= 4){
                runs += 3;
            }
            runners.set(i, num);
        }

    }
    private static void Homerun(List<Integer> runners, int runs){
        runs += (runners.size() + 1);
    }



}
