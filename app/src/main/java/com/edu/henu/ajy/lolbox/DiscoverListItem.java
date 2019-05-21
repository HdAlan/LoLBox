package com.edu.henu.ajy.lolbox;
public class DiscoverListItem {
    private int def;
    private String title;
    private String author;
    private String picturePath;
    private String content;

    public DiscoverListItem(int def, String title, String author, String picturePath, String content){
        this.def = def;
        this.title = title;
        this.author = author;
        this.picturePath = picturePath;
        this.content = content;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString(){
        return getDef()+","+getTitle()+"\n"+getAuthor()+","+getPicturePath();
    }

}
