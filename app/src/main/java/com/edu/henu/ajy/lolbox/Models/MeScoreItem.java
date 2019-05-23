package com.edu.henu.ajy.lolbox.Models;

public class MeScoreItem {
    private int hero_pic;
    private String score;
    private String category;
    private String time;
    public MeScoreItem(int pic, String score, String category, String time){
        this.hero_pic = pic;
        this.score = score;
        this.category = category;
        this.time = time;
    }

    public int getHero_pic() {
        return hero_pic;
    }

    public String getScore() {
        return score;
    }

    public String getCategory() {
        return category;
    }

    public String getTime() {
        return time;
    }
}
