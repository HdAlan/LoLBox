package com.edu.henu.ajy.lolbox;

public class CommunicateItem {
    int id;
    private String head_icoPath;
    private String userName;
    private int level;
    private String title;
    private String summary;
    private String articalImgPath;
    private String articalCate;
    private String articalTime;
    private int articalCommCounts;
    private int articalLikeCounts;

    public CommunicateItem(String head_icoPath, String userName, int level,String title, String summary, String articalImgPath,
                           String articalCate, String articalTime, int articalCommCounts, int articalLikeCounts){
        this.head_icoPath = head_icoPath;
        this.userName = userName;
        this.level = level;
        this.title = title;
        this.summary = summary;
        this.articalImgPath = articalImgPath;
        this.articalCate = articalCate;
        this.articalTime = articalTime;
        this.articalCommCounts = articalCommCounts;
        this.articalLikeCounts = articalLikeCounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHead_icoPath() {
        return head_icoPath;
    }

    public void setHead_icoPath(String head_icoPath) {
        this.head_icoPath = head_icoPath;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getArticalImgPath() {
        return articalImgPath;
    }

    public void setArticalImgPath(String articalImgPath) {
        this.articalImgPath = articalImgPath;
    }

    public String getArticalCate() {
        return articalCate;
    }

    public void setArticalCate(String articalCate) {
        this.articalCate = articalCate;
    }

    public String getArticalTime() {
        return articalTime;
    }

    public void setArticalTime(String articalTime) {
        this.articalTime = articalTime;
    }

    public int getArticalCommCounts() {
        return articalCommCounts;
    }

    public void setArticalCommCounts(int articalCommCounts) {
        this.articalCommCounts = articalCommCounts;
    }

    public int getArticalLikeCounts() {
        return articalLikeCounts;
    }

    public void setArticalLikeCounts(int articalLikeCounts) {
        this.articalLikeCounts = articalLikeCounts;
    }
}
