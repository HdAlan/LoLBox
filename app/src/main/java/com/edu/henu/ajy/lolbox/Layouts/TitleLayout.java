package com.edu.henu.ajy.lolbox.Layouts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.edu.henu.ajy.lolbox.R;


/**
 * 这是一个自定义的ActionBar
 */

public class TitleLayout extends LinearLayout {
    private ImageView back;
    private ImageView userHead;
    private TextView titleText;
    private TextView operateText;
    private ImageView forward;
    private View bottomLine;
    private TextView send;
    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_layout,this);
        userHead = findViewById(R.id.userHead);
        titleText = findViewById(R.id.barTitle);
        operateText = findViewById(R.id.operate);
        back = findViewById(R.id.back);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
        forward = findViewById(R.id.forward);
        bottomLine = findViewById(R.id.bottomLine);
        send = findViewById(R.id.send);
    }

    public void setTitle(String title){
        titleText.setText(title);
    }

    public void hideForward(){
        forward.setVisibility(INVISIBLE);
    }

    public void setUserHead(int bitmap){
        userHead.setImageResource(bitmap);
    }

    public void setOperate(String operate){
        operateText.setText(operate);
    }

    public void setTitleGravity(int origination){
        titleText.setGravity(origination);
    }

    public void setBackVisible(int vi){
        back.setVisibility(vi);
    }

    public void setUserHeadVisible(int vi){
        userHead.setVisibility(vi);
    }

    public ImageView getBack() {
        return back;
    }

    public void setBack(ImageView back) {
        this.back = back;
    }

    public ImageView getUserHead() {
        return userHead;
    }

    public void setUserHead(ImageView userHead) {
        this.userHead = userHead;
    }

    public TextView getTitleText() {
        return titleText;
    }

    public void setTitleText(TextView titleText) {
        this.titleText = titleText;
    }

    public TextView getOperateText() {
        return operateText;
    }

    public void setOperateText(TextView operateText) {
        this.operateText = operateText;
    }

    public ImageView getForward() {
        return forward;
    }

    public void setForward(ImageView forward) {
        this.forward = forward;
    }

    public View getBottomLine() {
        return bottomLine;
    }

    public void setBottomLine(View bottomLine) {
        this.bottomLine = bottomLine;
    }

    public TextView getSend() {
        return send;
    }

    public void setSend(TextView send) {
        this.send = send;
    }

    public void showSendBtn(){
        send.setVisibility(VISIBLE);
    }
}
