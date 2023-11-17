package Sorting;

import java.util.*;

public class MatchManager {
//-------------Function to list all teams-------------------------------------------------------------------------------
    public static ArrayList<String> getTeamArrayList() {
        ArrayList<String> uniqueTeam = new ArrayList<>();
        for (Match match : Match.getAllMatch()) {
            if (!uniqueTeam.contains(match.getTeamA())){
                uniqueTeam.add(match.getTeamA());
            }
            if (!uniqueTeam.contains(match.getTeamB()))
                uniqueTeam.add(match.getTeamB());
        }
        return uniqueTeam;
    }
//-------------Function for calculating the score of each team----------------------------------------------------------
    public static HashMap<String, Integer> getTeamScore() {
        HashMap<String, Integer> teamScore = new HashMap<>();
        for (Match match : Match.getAllMatch()) {
            if (teamScore.containsKey(match.getTeamA())) {
                Integer currentCount = teamScore.get(match.getTeamA());
                currentCount += match.getScoreTeamA();
                teamScore.put(match.getTeamA(), currentCount);
            }else{
                teamScore.put(match.getTeamA(), match.getScoreTeamA());
            }
        }
        for (Match match : Match.getAllMatch()) {
            if (teamScore.containsKey(match.getTeamB())) {
                Integer currentCount = teamScore.get(match.getTeamB());
                currentCount += match.getScoreTeamB();
                teamScore.put(match.getTeamB(), currentCount);
            }else{
                teamScore.put(match.getTeamB(), match.getScoreTeamB());
            }
        }
        return teamScore;
    }
//-------------Function for calculating the number of each map----------------------------------------------------------
    public static HashMap<String, Integer> getNumberOfMapOccurrences(){
        HashMap<String, Integer> numberOfMapOccurrences = new HashMap<>();
        for (Match match: Match.getAllMatch()) {
            if (numberOfMapOccurrences.containsKey(match.getTypeOfMatch())) {
                Integer currentCount = numberOfMapOccurrences.get(match.getTypeOfMatch());
                currentCount += 1;
                numberOfMapOccurrences.put(match.getTypeOfMatch(), currentCount);
            }else{
                numberOfMapOccurrences.put(match.getTypeOfMatch(), + 1);
            }
        }
        return numberOfMapOccurrences;
    }
}

