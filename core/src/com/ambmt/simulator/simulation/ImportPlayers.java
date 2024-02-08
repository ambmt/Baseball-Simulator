package com.ambmt.simulator.simulation;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImportPlayers {

    public void ImportPlayers() {
        // Initialize team abbreviations and years
        Map<String, String> abbrs = new HashMap<>();
        abbrs.put("home", "HOU");
        abbrs.put("away", "LAD");
        Map<String, String> years = new HashMap<>();
        years.put("home", "2021");
        years.put("away", "2021");

        // Load and print batters for home and away teams
        Map<String, List<String>> batters = LoadBatters(abbrs, years);
        System.out.println("Home Batters:");
        for (String batter : batters.get("home")) {
            System.out.println(batter);
        }
        System.out.println("Away Batters:");
        for (String batter : batters.get("away")) {
            System.out.println(batter);
        }

        // Load and print pitchers for home and away teams
        Map<String, List<String>> pitchers = LoadPitchers(abbrs, years);
        System.out.println("Home Pitchers:");
        for (String pitcher : pitchers.get("home")) {
            System.out.println(pitcher);
        }
        System.out.println("Away Pitchers:");
        for (String pitcher : pitchers.get("away")) {
            System.out.println(pitcher);
        }

        // Load and print relievers for home and away teams
        Map<String, List<String>> relievers = LoadRelievers(abbrs, years);
        System.out.println("Home Relievers:");
        for (String reliever : relievers.get("home")) {
            System.out.println(reliever);
        }
        System.out.println("Away Relievers:");
        for (String reliever : relievers.get("away")) {
            System.out.println(reliever);
        }

        // Load and print closers for home and away teams
        List<String> closers = LoadClosers(abbrs, years);
        System.out.println("Home Closer: " + closers.get(0));
        System.out.println("Away Closer: " + closers.get(1));
    }

    // Load batters for home and away teams
    public static Map<String, List<String>> LoadBatters(Map<String, String> abbrs, Map<String, String> years) {
        Map<String, List<String>> batters = new HashMap<>();
        batters.put("home", new ArrayList<>());
        batters.put("away", new ArrayList<>());

        try {
            // Connect to the baseball-reference website for home and away teams
            Document homePage = Jsoup.connect("https://www.baseball-reference.com/teams/" + abbrs.get("home") + "/" + years.get("home") + ".shtml").get();
            Document awayPage = Jsoup.connect("https://www.baseball-reference.com/teams/" + abbrs.get("away") + "/" + years.get("away") + ".shtml").get();

            // Select the batting table rows for home and away teams
            Elements homeBatters = homePage.select("#team_batting tbody tr");
            Elements awayBatters = awayPage.select("#team_batting tbody tr");

            // Iterate through the first 8 batters
            for (int i = 0; i < 8; i++) {
                Element homeBatter = homeBatters.get(i);
                Element awayBatter = awayBatters.get(i);

                // Extract full names of home and away batters
                String homeFullName = homeBatter.select("td:nth-child(2)").attr("csk");
                String awayFullName = awayBatter.select("td:nth-child(2)").attr("csk");

                // Split full names into first and last names
                String homeFirstName = homeFullName.split(",")[1].trim();
                String homeLastName = homeFullName.split(",")[0].trim();
                String awayFirstName = awayFullName.split(",")[1].trim();
                String awayLastName = awayFullName.split(",")[0].trim();

                // Add formatted names to the batters list
                batters.get("home").add(homeFirstName + " " + homeLastName);
                batters.get("away").add(awayFirstName + " " + awayLastName);
            }

            // Extract information for the 9th batter separately
            Element homeBatter9 = homeBatters.get(8);
            Element awayBatter9 = awayBatters.get(8);

            String homeFullName9 = homeBatter9.select("td:nth-child(2)").attr("csk");
            String awayFullName9 = awayBatter9.select("td:nth-child(2)").attr("csk");

            String homeFirstName9 = homeFullName9.split(",")[1].trim();
            String homeLastName9 = homeFullName9.split(",")[0].trim();
            String awayFirstName9 = awayFullName9.split(",")[1].trim();
            String awayLastName9 = awayFullName9.split(",")[0].trim();

            // Add formatted names of the 9th batter to the batters list
            batters.get("home").add(homeFirstName9 + " " + homeLastName9);
            batters.get("away").add(awayFirstName9 + " " + awayLastName9);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return batters;
    }

    // Load pitchers for home and away teams
    public static Map<String, List<String>> LoadPitchers(Map<String, String> abbrs, Map<String, String> years) {
        Map<String, List<String>> pitchers = new HashMap<>();
        pitchers.put("home", new ArrayList<>());
        pitchers.put("away", new ArrayList<>());

        try {
            // Connect to the baseball-reference website for home and away teams
            Document homePage = Jsoup.connect("https://www.baseball-reference.com/teams/" + abbrs.get("home") + "/" + years.get("home") + ".shtml").get();
            Document awayPage = Jsoup.connect("https://www.baseball-reference.com/teams/" + abbrs.get("away") + "/" + years.get("away") + ".shtml").get();

            // Select the pitching table rows for home and away teams
            Elements homePitchers = homePage.select("#team_pitching tbody tr");
            Elements awayPitchers = awayPage.select("#team_pitching tbody tr");

            // Iterate through the first 12 pitchers
            for (int i = 0; i < 12; i++) {
                Element homePitcher = homePitchers.get(i);
                Element awayPitcher = awayPitchers.get(i);

                // Extract full names of home and away pitchers
                String homeFullName = homePitcher.select("td:nth-child(2)").attr("csk");
                String awayFullName = awayPitcher.select("td:nth-child(2)").attr("csk");

                // Split full names into first and last names
                String homeFirstName = homeFullName.split(",")[1].trim();
                String homeLastName = homeFullName.split(",")[0].trim();
                String awayFirstName = awayFullName.split(",")[1].trim();
                String awayLastName = awayFullName.split(",")[0].trim();

                // Extract the position of the pitcher (e.g., CL for closer)
                String homePosition = homePitcher.select("td:nth-child(1) strong").text();
                String awayPosition = awayPitcher.select("td:nth-child(1) strong").text();

                // Add formatted names or placeholders for closers to the pitchers list
                if (homePosition.equals("CL")) {
                    pitchers.get("home").add("_EMPTY_");
                } else {
                    pitchers.get("home").add(homeFirstName + " " + homeLastName);
                }

                if (awayPosition.equals("CL")) {
                    pitchers.get("away").add("_EMPTY_");
                } else {
                    pitchers.get("away").add(awayFirstName + " " + awayLastName);
                }
            }

            // Remove placeholder entries for closers from the pitchers list
            pitchers.get("home").removeIf(pitcher -> pitcher.equals("_EMPTY_"));
            pitchers.get("away").removeIf(pitcher -> pitcher.equals("_EMPTY_"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return pitchers;
    }

    // Load relievers for home and away teams
    public static Map<String, List<String>> LoadRelievers(Map<String, String> abbrs, Map<String, String> years) {
        Map<String, List<String>> relievers = new HashMap<>();
        relievers.put("home", new ArrayList<>());
        relievers.put("away", new ArrayList<>());

        try {
            // Connect to the baseball-reference website for home and away teams
            Document homePage = Jsoup.connect("https://www.baseball-reference.com/teams/" + abbrs.get("home") + "/" + years.get("home") + ".shtml").get();
            Document awayPage = Jsoup.connect("https://www.baseball-reference.com/teams/" + abbrs.get("away") + "/" + years.get("away") + ".shtml").get();

            // Select the pitching table rows for home and away teams
            Elements homePitchers = homePage.select("#team_pitching tbody tr");
            Elements awayPitchers = awayPage.select("#team_pitching tbody tr");

            // Iterate through the first 12 pitchers
            for (int i = 0; i < 12; i++) {
                Element homePitcher = homePitchers.get(i);
                Element awayPitcher = awayPitchers.get(i);

                // Extract full names of home and away relievers
                String homeFullName = homePitcher.select("td:nth-child(2)").attr("csk");
                String awayFullName = awayPitcher.select("td:nth-child(2)").attr("csk");

                // Split full names into first and last names
                String homeFirstName = homeFullName.split(",")[1].trim();
                String homeLastName = homeFullName.split(",")[0].trim();
                String awayFirstName = awayFullName.split(",")[1].trim();
                String awayLastName = awayFullName.split(",")[0].trim();

                // Extract the position of the reliever (e.g., CL for closer)
                String homePosition = homePitcher.select("td:nth-child(1) strong").text();
                String awayPosition = awayPitcher.select("td:nth-child(1) strong").text();

                // Add formatted names or placeholders for closers to the relievers list
                if (homePosition.equals("CL")) {
                    relievers.get("home").add("_EMPTY_");
                } else {
                    relievers.get("home").add(homeFirstName + " " + homeLastName);
                }

                if (awayPosition.equals("CL")) {
                    relievers.get("away").add("_EMPTY_");
                } else {
                    relievers.get("away").add(awayFirstName + " " + awayLastName);
                }
            }

            // Remove placeholder entries for closers from the relievers list
            relievers.get("home").removeIf(reliever -> reliever.equals("_EMPTY_"));
            relievers.get("away").removeIf(reliever -> reliever.equals("_EMPTY_"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return relievers;
    }

    // Load closers for home and away teams
    public static List<String> LoadClosers(Map<String, String> abbrs, Map<String, String> years) {
        List<String> closers = new ArrayList<>();

        try {
            // Connect to the baseball-reference website for home and away teams
            Document homePage = Jsoup.connect("https://www.baseball-reference.com/teams/" + abbrs.get("home") + "/" + years.get("home") + ".shtml").get();
            Document awayPage = Jsoup.connect("https://www.baseball-reference.com/teams/" + abbrs.get("away") + "/" + years.get("away") + ".shtml").get();

            // Select the pitching table rows for home and away teams
            Elements homePitchers = homePage.select("#team_pitching tbody tr");
            Elements awayPitchers = awayPage.select("#team_pitching tbody tr");

            // Iterate through the first 12 pitchers
            for (int i = 0; i < 12; i++) {
                Element homePitcher = homePitchers.get(i);
                Element awayPitcher = awayPitchers.get(i);

                // Extract full names of home and away closers
                String homeFullName = homePitcher.select("td:nth-child(2)").attr("csk");
                String awayFullName = awayPitcher.select("td:nth-child(2)").attr("csk");

                // Split full names into first and last names
                String homeFirstName = homeFullName.split(",")[1].trim();
                String homeLastName = homeFullName.split(",")[0].trim();
                String awayFirstName = awayFullName.split(",")[1].trim();
                String awayLastName = awayFullName.split(",")[0].trim();

                // Extract the position of the closer (e.g., CL for closer)
                String homePosition = homePitcher.select("td:nth-child(1) strong").text();
                String awayPosition = awayPitcher.select("td:nth-child(1) strong").text();

                // Add formatted names of closers to the closers list
                if (homePosition.equals("CL")) {
                    closers.add(homeFirstName + " " + homeLastName);
                }

                if (awayPosition.equals("CL")) {
                    closers.add(awayFirstName + " " + awayLastName);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return closers;
    }
}
