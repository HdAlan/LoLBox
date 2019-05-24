package com.edu.henu.ajy.lolbox.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.edu.henu.ajy.lolbox.R;
import com.edu.henu.ajy.lolbox.Utils.DBHelper;

public class SettingActivity extends AppCompatActivity {


    public static void startThisActivity(Activity activity){
        Intent intent = new Intent(activity,SettingActivity.class);
        activity.startActivity(intent);
    }

    private LinearLayout logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().hide();

        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //退出登录时，先清空User表，再启动LoginAccountActivity
                DBHelper dbHelper = new DBHelper(SettingActivity.this,"User.db",null,1);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("delete from User");
                LoginAccountActivity.startThisActivity(SettingActivity.this);
            }
        });

    }
}
