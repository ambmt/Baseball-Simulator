package com.ambmt.simulator.players;

import java.util.List;

class Team {
    private List<Player> pitchers;
    private List<Player> batters;

    public Team(List<Player> pitchers, List<Player> batters) {
        this.pitchers = pitchers;
        this.batters = batters;
    }

    public List<Player> getPitchers() {
        return pitchers;
    }

    public List<Player> getBatters() {
        return batters;
    }
}
