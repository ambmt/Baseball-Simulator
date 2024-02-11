package com.ambmt.simulator;

import com.ambmt.simulator.players.Batter;
import com.ambmt.simulator.players.Player;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExportStats {

    public void exportAvgToStatsFile(List<Player> batterList, String name){
        ObjectMapper objectMapper = new ObjectMapper();
        Date date = new Date();

        String filePath = name + ".json";
        Map<String, Map<String, Double>> playersStatsMap = new HashMap<>();
        for(Player player: batterList){
            Batter batter = (Batter) player;
            String playerName = batter.getName();
            Map<String, Double> playerStats = batter.getFullStats();
            playersStatsMap.put(playerName, playerStats);
        }
        try {
            // Write the playersStatsMap to a JSON file
            objectMapper.writeValue(new File(filePath), playersStatsMap);
            System.out.println("Player stats exported to " + filePath);
            // remember to replace catch with the new function
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
