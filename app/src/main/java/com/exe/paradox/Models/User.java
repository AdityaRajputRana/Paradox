package com.exe.paradox.Models;

public class User {
    String name;
    String uid;
    String displayPicture;
    int score;
    String roll;
    String ref_code;
    String team_code;

    public String getRoll() {
        return roll;
    }

    public String getRef_code() {
        return ref_code;
    }

    public String getTeam_code() {
        return team_code;
    }

    public int getPoints() {
        return score;
    }
    public int getScore() {
        return score;
    }

    int rank;

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public String getDisplayPicture() {
        return displayPicture;
    }

    public int getRank() {
        return rank;
    }
}
