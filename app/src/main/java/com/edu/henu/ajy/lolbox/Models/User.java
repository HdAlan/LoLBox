package com.edu.henu.ajy.lolbox.Models;

import android.graphics.Bitmap;

import java.io.Serializable;

public class User implements Serializable {
    private String account;
    private String password;
    private String headImgPath;
    private String uname;
    private int level;
    private int focus;
    private int fans;
    private int thumbs;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadImgPath() {
        return headImgPath;
    }

    public void setHeadImgPath(String headImgPath) {
        this.headImgPath = headImgPath;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getFocus() {
        return focus;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public int getThumbs() {
        return thumbs;
    }

    public void setThumbs(int thumbs) {
        this.thumbs = thumbs;
    }
}
