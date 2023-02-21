package com.exe.paradox.rest.response;

import com.exe.paradox.Models.Banner;
import com.exe.paradox.Models.User;

import java.util.ArrayList;

public class HomeRP {
    String playerName;
    boolean isSolo;
    String teamName;
    boolean isLevelLocked;
    int nextQuestionNumber;

    int level;
    ArrayList<Banner> banners;
    ArrayList<User> leaderboard;
    boolean isLevelActive;
    long levelStartsInSeconds;
    long levelStartsAt;

    public HomeRP() {
    }

    public ArrayList<User> getLeaderboard() {
        return leaderboard;
    }

    public ArrayList<Banner> getBanners() {
        return banners;
    }

    public int getLevel() {
        return level;
    }

    public String getLevelName(){
        return String.valueOf(level);
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean isSolo() {
        return isSolo;
    }

    public String getTeamName() {
        return teamName;
    }

    public boolean isLevelActive() {
        return isLevelActive;
    }

    public boolean isLevelLocked() {
        return isLevelLocked;
    }

    public long getLevelStartsInSeconds() {
        return levelStartsInSeconds;
    }

    public long getLevelStartsAt() {
        return levelStartsAt;
    }

    public int getNextQuestionNumber() {
        return nextQuestionNumber;
    }
}
