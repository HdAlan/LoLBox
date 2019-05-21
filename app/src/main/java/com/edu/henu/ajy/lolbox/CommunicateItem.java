package com.edu.henu.ajy.lolbox;

public class CommunicateItem {
    private int head_ico;
    private String userName;
    private String level;
    private int levelBoardBg;
    private String title;
    private String summary;
    private int articalImg;
    private String articalCate;
    private String articalTime;
    private String articalCommCounts;
    private String articalLikeCounts;

    public CommunicateItem(int head_ico, String userName, String level, int levelBoardBg, String title, String summary, int articalImg,
                           String articalCate, String articalTime, String articalCommCounts, String articalLikeCounts){
        this.head_ico = head_ico;
        this.userName = userName;
        this.level = level;
        this.levelBoardBg = levelBoardBg;
        this.title = title;
        this.summary = summary;
        this.articalImg = articalImg;
        this.articalCate = articalCate;
        this.articalTime = articalTime;
        this.articalCommCounts = articalCommCounts;
        this.articalLikeCounts = articalLikeCounts;
    }

    public int getHead_ico() {
        return head_ico;
    }

    public String getUserName() {
        return userName;
    }

    public String getLevel() {
        return level;
    }

    public int getLevelBoardBg() {
        return levelBoardBg;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public int getArticalImg() {
        return articalImg;
    }

    public String getArticalCate() {
        return articalCate;
    }

    public String getArticalTime() {
        return articalTime;
    }

    public String getArticalCommCounts() {
        return articalCommCounts;
    }

    public String getArticalLikeCounts() {
        return articalLikeCounts;
    }
}
