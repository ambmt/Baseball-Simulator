package com.ambmt.simulator.players;

class Pitcher extends Player {
    private double earnedRunAvgPlus;

    public Pitcher(String name, double earnedRunAvgPlus) {
        super(name);
        this.earnedRunAvgPlus = earnedRunAvgPlus;
    }

    public double getEarnedRunAvgPlus() {
        return earnedRunAvgPlus;
    }
}