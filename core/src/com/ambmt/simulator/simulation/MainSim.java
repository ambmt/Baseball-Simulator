package com.ambmt.simulator.simulation;

import com.ambmt.simulator.players.*;
import com.ambmt.simulator.views.game.ScoreBug;
import com.ambmt.simulator.views.menus.InGameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.ArrayList;
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
    private boolean homeActive;
    private InGameScreen inGameScreen;
    private int homeHits;
    private int awayHits;
    private ScoreBug scoreBug;
    private Skin skin;



    public boolean isGameActive() {
        return gameActive;
    }



    public void init(InGameScreen ig){
        random = new Random();
        tempSim = new TempSim();
        this.outs = 0;
        this.innings = 0;
        TeamBuilder tb = new TeamBuilder();
        tb.importJSON(0,0);
        homeTeam = tb.homeTeam;
        awayTeam = tb.awayTeam;
        this.runners = new boolean[4];
        this.inGameScreen = ig;
        scoreBug = inGameScreen.getScoreBug();


    }

    public void runSim() {
        new Thread((() -> {
                synchronized (this) {
                    while (this.isGameActive()) {
                        this.runAb();
                        try{
                            Thread.sleep(10);
                        }catch(InterruptedException e){
                            throw new RuntimeException(e);
                        }

                    }
                }
        })).start();
    }

    public void runAb() {
        int result;
        int strikes = 0;
        playerOnBase();
        int newIndex;
        Pitcher pitcher;
        Batter batter;

        int pitchCount;
        if (homeActive) {
            pitcher = (Pitcher) awayTeam.getPitchers().get(0);
            newIndex = homeIndex;
            batter = (Batter) homeTeam.getBatters().get(newIndex);
        } else {
            pitcher = (Pitcher) homeTeam.getPitchers().get(0);
            newIndex = awayIndex;
            batter = (Batter) awayTeam.getBatters().get(newIndex);
        }
        int margin = calculateMargin(batter, pitcher);
        if (margin > 0) {
            edgePos = "batter";
        } else {
            // Set edge for pitcher and make the number positive now.
            edgePos = "pitcher";
            margin *= -1;
        }
        pitchCount = 1;
        do {
            result = tempSim.calculatePitchOutcome(pitchCount, false, edgePos, margin, 0, random);
            pitchCount++;
            if (result == 1) {
                strikes++;
            }
        } while (result != 3 && strikes <= 2 && result != 0);  // Stop if hit or 3 strikes
        newIndex++;
        System.out.println(newIndex);
        if (result == 3) {
            if (random.nextInt(1000) + 1 <= 248) {
                generateRandomHit(batter, pitcher);
            } else {
                outs++;
                Out(batter, outs);
            }
        }
        if (strikes == 3) {
            outs++;
            strikeOut(batter, pitcher, outs);
        }
        if (newIndex >= 8) {
            // Resetting the lineup
            newIndex = 0;
        }
        if (outs >= 3) {
            System.out.println("Home: " + homeScore);
            System.out.println("Away: " + awayScore);
            clearBases();
            if (homeActive) {
                homeScore += runs;
                runs = 0;
            } else {
                awayScore += runs;
                runs = 0;
            }
            // A new inning should only be called when the home team has just batted. This being called all the time shortened the game significantly
            if (homeActive) {
                innings++;
            }
            outs = 0;
            homeActive = !homeActive;
        }
        if (homeActive) {
            homeIndex = newIndex;
        } else {
            awayIndex = newIndex;
        }
        // This is a check to allow games to go into extra innings
        // Home must be active as they always bat second
        if (innings > 8 && (homeScore != awayScore) && homeActive) {
            this.gameActive = false;
            if(homeScore> awayScore){
                callUpdate("Home team wins - " + homeScore + " to " + awayScore);
            }else{
                callUpdate("Away team wins - " + awayScore + " to " + homeScore);
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
        if(homeActive){
            homeHits++;
        }
        else{
            awayHits++;
        }
        if (hit <= 63){
            hitSingle();
            callUpdate(batter.getName() + " singles off " + pitcher.getName());
            return;
        }
        if(hit <= 80){
            hitDouble();
            callUpdate(batter.getName() + " doubles off " + pitcher.getName());
            return;
        }
        if(hit <= 95){
            hitHomeRun();
            callUpdate(batter.getName() + " hits a homerun off " + pitcher.getName());
            return;
        }
        else{
            callUpdate(batter.getName() + " triples off " + pitcher.getName());
            hitTriple();

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
        }
        else{
            callUpdate(player.getName() + " flies out, " + outs + " down.");
        }
    }
    private void strikeOut(Batter batter, Pitcher pitcher, int outs){
        callUpdate(batter.getName() + " strikes out against " + pitcher.getName() + "," + outs + " outs.");
    }

    private void callUpdate(String event){
        try {
            scoreBug.updateScorebug(homeScore, homeHits, 0, innings, awayScore, awayHits, 0, innings);
        }catch(NullPointerException e){
            scoreBug = inGameScreen.getScoreBug();
            scoreBug.updateScorebug(homeScore, homeHits, 0, innings, awayScore, awayHits, 0, innings);
            return;
        }
        Gdx.app.postRunnable(() -> inGameScreen.updateGUI(false,true,"", event));
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

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }





}


