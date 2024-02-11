package com.ambmt.simulator.players;

import java.util.Map;
import java.util.Objects;

public class Batter extends Player {
    private String onBasePercentage;
    private Map<String, Double> stats;

    public Batter(String name, String onBasePercentage, Map<String, Double> stats) {
        super(name);
        if(Objects.equals(onBasePercentage, "")){
            onBasePercentage = "100";
        }
        this.onBasePercentage = onBasePercentage;
        this.stats = stats;

    }

    public String getOnBasePercentage() {
        return onBasePercentage;
    }
    public void addStats(String key, double value){

    }
    public double getStats(String key){
        return stats.getOrDefault(key, 0.0);
    }

    public Map<String, Double> getFullStats(){
        return stats;
    }
}