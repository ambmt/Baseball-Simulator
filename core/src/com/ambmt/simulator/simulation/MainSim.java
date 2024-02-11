package com.ambmt.simulator.simulation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.util.logging.FileHandler;

public class MainSim {

    private int runs;
    private boolean gameActive = true;
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
        List<Boolean> runners= newInning();
        calculateMargin(0,0);
        while(gameActive){
            int result;
            int strikes = 0;
            newAb(runners);
            do{
                result = tempSim.calculatePitchOutcome(1,false,"batter",20,0,random);
                if(result == 1){
                    strikes++;
                }
            }while (result !=3 && strikes <= 2);
            if(result == 3){
                runners = generateRandomHit(runners);
            }
            if (strikes == 3){
                outs++;
            }
            if (outs >= 3){
                runners = newInning();
                innings++;
            }
            // Temp sim
            if (innings > 1){
                gameActive = false;
            }


        }
    }

    // Using https://cran.r-project.org/web/packages/Lahman/vignettes/hits-by-type.html to determine the probability of outcomes. gen 1-100 number.
    // 1- 63 = Single
    // 63-80 = Double
    // 80 - 95 = Homerun
    // 95 - 100 = Triple
    private List<Boolean> generateRandomHit(List<Boolean> runners){
        int hit = random.nextInt(100) + 1;
        if (hit <= 63){
            runners = Single(runners);
            return runners;
        }
        if(hit <= 80){
            runners = Double(runners);
            return runners;
        }
        if(hit <= 95){
            Homerun(runners);
            return runners;
        }
        else{
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

    private void callUpdate(){

    }

    private List<Boolean> newAb(List<Boolean> runners){
        runners.set(0, true);
        return runners;
    }

    public void calculateMargin(int HomeIndex, int AwayIndex){
        try {
            // Use the class loader to get the InputStream for the file
            FileHandle fileHandler = Gdx.files.internal("players_stats.json");
            InputStream inputStream  = fileHandler.read();


            if (inputStream != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(inputStream);

                // Import the pitcher array, home, and away
                JsonNode pitchersNode = rootNode.at("/away/0/pitchers");
                JsonNode homeNode = rootNode.at("/home");
                JsonNode awayNode = rootNode.at("/away");

                // Convert to lists
                List<String> pitchersList = objectMapper.convertValue(pitchersNode, new TypeReference<List<String>>() {});
                List<String> homeList = objectMapper.convertValue(homeNode, new TypeReference<List<String>>() {});
                List<String> awayList = objectMapper.convertValue(awayNode, new TypeReference<List<String>>() {});

                // Access elements using indices
                String selectedHomePitcherName = pitchersList.get(HomeIndex);
                String selectedAwayPitcherName = pitchersList.get(AwayIndex);
                String selectedHomeStat = homeList.get(HomeIndex);
                String selectedAwayStat = awayList.get(AwayIndex);

                // Print information
                System.out.println("Selected Home Pitcher Name: " + selectedHomePitcherName);
                System.out.println("Selected Away Pitcher Name: " + selectedAwayPitcherName);
                System.out.println("Selected Home Stat: " + selectedHomeStat);
                System.out.println("Selected Away Stat: " + selectedAwayStat);

                // Close the InputStream
                inputStream.close();
            } else {
                System.out.println("File not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


