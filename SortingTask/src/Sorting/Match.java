package Sorting;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

public class Match {

    private int id;
    private String matchURL;
    private int matchId;
    private String teamA;
    private String teamB;
    private int scoreTeamA;
    private int scoreTeamB;
    private String competition;
    private String typeOfMatch;

    public Match(int id, String matchURL, int matchId, String teamA, String teamB, int scoreTeamA, int scoreTeamB, String competition, String typeOfMatch) {
        this.id = id;
        this.matchURL = matchURL;
        this.matchId = matchId;
        this.teamA = teamA;
        this.teamB = teamB;
        this.scoreTeamA = scoreTeamA;
        this.scoreTeamB = scoreTeamB;
        this.competition = competition;
        this.typeOfMatch = typeOfMatch;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", matchURL='" + matchURL + '\'' +
                ", matchId=" + matchId +
                ", teamA='" + teamA + '\'' +
                ", teamB='" + teamB + '\'' +
                ", scoreTeamA=" + scoreTeamA +
                ", scoreTeamB=" + scoreTeamB +
                ", competition='" + competition + '\'' +
                ", typeOfMatch='" + typeOfMatch + '\'' +
                '}';
    }
//----------------Function for load all data from CSV file--------------------------------------------------------------
    public static ArrayList<Match> fileFromResourceToArrayList(String fileName) {
            ArrayList<Match> matches = new ArrayList<>();
            URL path = Match.class.getClassLoader().getResource(fileName);
            assert path != null;
            String filePath = URLDecoder.decode(path.getFile(), StandardCharsets.UTF_8);
            File file = new File(filePath);
            boolean isHeader = true;
            try {
                for (String line : Files.readAllLines(file.toPath())) {
                    if (isHeader){
                        isHeader = false;
                        continue;
                    }
                    String[] data = line.split(";");
                    int id = Integer.parseInt(data[0]);
                    String matchUrl = data[1];
                    int matchId = Integer.parseInt(data[2]);
                    String teamA = data[3];
                    String teamB = data[4];
                    int scoreTeamA = Integer.parseInt(data[5]);
                    int scoreTeamB = Integer.parseInt(data[6]);
                    String competetion = data[7];
                    String typeOfMatch = data[8];
                    Match match = new Match(id, matchUrl, matchId, teamA, teamB, scoreTeamA, scoreTeamB, competetion, typeOfMatch);
                    matches.add(match);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return matches;
        }

    public static ArrayList<Match> getAllMatch(){
          return  fileFromResourceToArrayList("Sorting/HLTV_CSGO_results.csv");
        }


    public int getId() {
        return id;
    }

    public String getMatchURL() {
        return matchURL;
    }

    public int getMatchId() {
        return matchId;
    }

    public String getTeamA() {
        return teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public int getScoreTeamA() {
        return scoreTeamA;
    }

    public int getScoreTeamB() {
        return scoreTeamB;
    }

    public String getCompetition() {
        return competition;
    }

    public String getTypeOfMatch() {
        return typeOfMatch;
    }
}


