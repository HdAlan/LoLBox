package com.edu.henu.ajy.lolbox.Layouts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.edu.henu.ajy.lolbox.R;

public class TitleLayout extends LinearLayout {
    private String text;
    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_layout,this);
    }
}
