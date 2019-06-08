package com.edu.henu.ajy.lolbox.Models;

public class FriendNewsItem {
    private int headImageId;
    private String username;
    private String message;

    //设置关注状态
    //0为相互关注，1为被关注，2为未被关注
    private int focusState;

    //消息、好友列表
    public FriendNewsItem(int headImageId,String username,String message){
        this.headImageId = headImageId;
        this.username = username;
        this.message = message;
    }
    //关注列表
    public FriendNewsItem(int headImageId,String username,int focusState){
        this.headImageId = headImageId;
        this.username = username;
        this.focusState = focusState;
    }

    public int getHeadImageId() {
        return headImageId;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }

    public int getFocusState() {
        return focusState;
    }
}
