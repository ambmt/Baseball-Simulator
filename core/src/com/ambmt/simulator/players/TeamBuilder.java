package com.ambmt.simulator.players;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.*;

public class TeamBuilder {
    public Team homeTeam;
    public Team awayTeam;
    public void importJSON(int HomeIndex, int AwayIndex) {
        try {
            // Use the class loader to get the InputStream for the file
            FileHandle fileHandler = Gdx.files.internal("players_stats.json");
            InputStream inputStream = fileHandler.read();

            if (inputStream != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(inputStream);

                // Create teams
                homeTeam = createTeam(rootNode, "home");
                awayTeam = createTeam(rootNode, "away");

                // Access elements using indices
                Player selectedHomePitcher = homeTeam.getPitchers().get(HomeIndex);
                Player selectedAwayPitcher = awayTeam.getPitchers().get(AwayIndex);

                // Print information - THIS WILL LATER BE CHANGED TO DISPLAY IN THE FEED
                System.out.println("Selected Home Pitcher Name: " + selectedHomePitcher.getName());
                System.out.println("Selected Away Pitcher Name: " + selectedAwayPitcher.getName());

                // Close the InputStream
                inputStream.close();
            } else {
                System.out.println("File not found");
            }
        } catch (Exception e) {
            // TO-DO FIX THIS
            e.printStackTrace();
        }
    }



    private Team createTeam(JsonNode rootNode, String teamType) {
        JsonNode teamNode = rootNode.at("/" + teamType).get(0);

        List<Player> pitchers = createPlayers(teamNode.get("pitchers"));
        List<Player> batters = createPlayers(teamNode.get("batters"));
        List<Player> t = new Team(pitchers, batters).getPitchers();
        List<Player> f = new Team(pitchers, batters).getBatters();
        for(Player player: t){
            if(player instanceof Pitcher){
                Pitcher p = (Pitcher) player;
                System.out.println(p.getName() + " " + p.getEarnedRunAvgPlus());
            }
        }
        for(Player player : f){
            if(player instanceof Batter){
                Batter b = (Batter) player;
                System.out.println(b.getName() + " " + b.getOnBasePercentage());
            }
        }
        return new Team(pitchers, batters);
    }

    private List<Player> createPlayers(JsonNode playersNode) {
        List<Player> players = new ArrayList<>();
        Iterator<JsonNode> playerIterator = playersNode.elements();

        while (playerIterator.hasNext()) {
            JsonNode playerNode = playerIterator.next();
            String name = playerNode.get("name").asText();

            // Check the player type (pitcher or batter) based on the available attributes
            if (playerNode.has("earned_run_avg_plus")) {
                // It's a pitcher
                int earnedRunAvgPlus = Integer.parseInt(playerNode.get("earned_run_avg_plus").asText());
                players.add(new Pitcher(name, earnedRunAvgPlus));
            } else {
                // It's a batter
                String onBasePercentage = playerNode.get("on_base_percentage").asText();
                Map<String, Double> hm = new HashMap<>();
                hm.put("avg" , 1.000);
                hm.put("1B", 0.0);
                hm.put("2B", 0.0);
                hm.put("3B", 0.0);
                hm.put("HR", 0.0);
                hm.put("K", 0.0);
                players.add(new Batter(name, onBasePercentage, hm));
            }
        }

        return players;
    }
}


