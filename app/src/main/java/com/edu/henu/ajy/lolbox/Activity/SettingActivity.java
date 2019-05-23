package com.edu.henu.ajy.lolbox.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.edu.henu.ajy.lolbox.R;

public class SettingActivity extends AppCompatActivity {

    public static void startThisActivity(Activity activity){
        Intent intent = new Intent(activity,SettingActivity.class);
        activity.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        getSupportActionBar().hide();

    }
}
