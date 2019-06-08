package com.edu.henu.ajy.lolbox.Models;

public class MeScoreItem {
    private String heroPicPath;
    private String fightRes;
    private String category;
    private String time;
    public MeScoreItem(String pic, String score, String category, String time){
        this.heroPicPath = pic;
        this.fightRes = score;
        this.category = category;
        this.time = time;
    }

    public String getHeroPicPath() {
        return heroPicPath;
    }

    public String getFightRes() {
        return fightRes;
    }

    public String getCategory() {
        return category;
    }

    public String getTime() {
        return time;
    }
}
