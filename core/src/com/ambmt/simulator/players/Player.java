package com.ambmt.simulator.players;

import java.util.Map;

public class Player {
    private String name;
    private Map<String, Double> stats;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}