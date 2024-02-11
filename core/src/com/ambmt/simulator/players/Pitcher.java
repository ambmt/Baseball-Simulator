package com.ambmt.simulator.players;

public class Pitcher extends Player {
    private int earnedRunAvgPlus;

    public Pitcher(String name, int earnedRunAvgPlus) {
        super(name);
        this.earnedRunAvgPlus = earnedRunAvgPlus;
    }

    public int getEarnedRunAvgPlus() {
        return earnedRunAvgPlus;
    }
}