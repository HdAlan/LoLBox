package com.edu.henu.ajy.lolbox.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import com.edu.henu.ajy.lolbox.Layouts.TitleLayout;
import com.edu.henu.ajy.lolbox.Models.User;
import com.edu.henu.ajy.lolbox.R;
import com.edu.henu.ajy.lolbox.Utils.DBHelper;
import com.edu.henu.ajy.lolbox.Utils.HttpUtil;

public class SettingActivity extends AppCompatActivity {


    public static void startThisActivity(Activity activity, User user){
        Intent intent = new Intent(activity,SettingActivity.class);
        intent.putExtra("user",user);
        activity.startActivity(intent);
    }


    private User user;
    private TitleLayout titleLayout;
    private TitleLayout userCard;
    private TitleLayout security;
    private TitleLayout accountManager;
    private TitleLayout generalSetting;
    private TitleLayout privateSetting;
    private TitleLayout aboutLoLBox;
    private TitleLayout checkUpdate;
    private TitleLayout logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        //设置顶部导航栏
        getSupportActionBar().hide();
        titleLayout = findViewById(R.id.titleLayout);
        titleLayout.setTitle("设置");
        titleLayout.setTitleGravity(Gravity.CENTER);
        titleLayout.setBackVisible(View.VISIBLE);
        titleLayout.hideForward();
        //设置用户名片
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("user");
        userCard = findViewById(R.id.userCard);
        userCard.setTitle(user.getUname());
        userCard.setOperate("修改");
        HttpUtil.getImgBitmap(SettingActivity.this,userCard.getUserHead(),MainActivity.PICTUREPATHPRE,user.getHeadImgPath());
        userCard.setUserHeadVisible(View.VISIBLE);
        //安全
        security= findViewById(R.id.security);
        security.setTitle("安全与绑定");
        //账户管理
        accountManager = findViewById(R.id.accountManager);
        accountManager.setTitle("游戏账号管理");
        //通用设置
        generalSetting = findViewById(R.id.generalSetting);
        generalSetting.setTitle("通用设置");
        //隐私设置
        privateSetting = findViewById(R.id.privateSetting);
        privateSetting.setTitle("隐私设置");
        //关于
        aboutLoLBox = findViewById(R.id.aboutLoLBox);
        aboutLoLBox.setTitle("关于");
        //检查更新
        checkUpdate= findViewById(R.id.checkUpdate);
        checkUpdate.setTitle("检查更新");
        //退出登录
        logout = findViewById(R.id.logOut);
        logout.setTitle("退出登录");
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //退出登录时，先清空User表，再启动LoginAccountActivity
                DBHelper dbHelper = new DBHelper(SettingActivity.this,"User.db",null,LoginAccountActivity.DBUSER_VERSION);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("delete from User");
                LoginAccountActivity.startThisActivity(SettingActivity.this);
            }
        });

    }
}
