package com.ambmt.simulator.players;

import java.util.Objects;

public class Batter extends Player {
    private String onBasePercentage;

    public Batter(String name, String onBasePercentage) {
        super(name);
        if(Objects.equals(onBasePercentage, "")){
            onBasePercentage = "100";
        }
        this.onBasePercentage = onBasePercentage;
    }

    public String getOnBasePercentage() {
        return onBasePercentage;
    }
}