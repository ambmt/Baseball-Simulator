package com.ambmt.simulator.players;

class Batter extends Player {
    private String onBasePercentage;

    public Batter(String name, String onBasePercentage) {
        super(name);
        this.onBasePercentage = onBasePercentage;
    }

    public String getOnBasePercentage() {
        return onBasePercentage;
    }
}