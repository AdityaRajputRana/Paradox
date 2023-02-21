package com.exe.paradox.Models;

public class User {
    String name;
    String uid;
    String displayPicture;
    int score;

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
