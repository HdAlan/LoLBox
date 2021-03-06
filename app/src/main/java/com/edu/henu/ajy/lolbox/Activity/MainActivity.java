package com.edu.henu.ajy.lolbox.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.edu.henu.ajy.lolbox.Fragments.CommunicateFragment;
import com.edu.henu.ajy.lolbox.Fragments.DiscoverFragment;
import com.edu.henu.ajy.lolbox.Fragments.FriendFragment;
import com.edu.henu.ajy.lolbox.Fragments.MeFragment;
import com.edu.henu.ajy.lolbox.Models.User;
import com.edu.henu.ajy.lolbox.R;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    public static String GETDISCOVERLIST="http://henuajy.zicp.vip/lolboxserver/GetDiscoverRecommentListServlet";
    public static String PICTUREPATHPRE = "http://henuajy.zicp.vip/LolboxImages/";
    public static String GETCOMMUNITYLIST="http://henuajy.zicp.vip/lolboxserver/GetCommunityListServlet";
    public static String PUBLISHCOMMUNITY="http://henuajy.zicp.vip/lolboxserver/InsertCommunityServlet";
    public static String LOGINSERVER = "http://henuajy.zicp.vip/lolboxserver/LoginServlet";
    public static String REGISTERSERVER = "http://henuajy.zicp.vip/lolboxserver/RegisterServlet";
    public static String GetUserInfo="http://henuajy.zicp.vip/lolboxserver/GetUserInfoServlet";
    public static String GETSCORELIST="http://henuajy.zicp.vip/lolboxserver/GetScoreListServlet";
    public static String GETCOMMENTS="http://henuajy.zicp.vip/lolboxserver/GetCommentsServlet";
    public static String SENDCOMMENT="http://henuajy.zicp.vip/lolboxserver/SendCommentServlet";
    private BottomNavigationView bottomNavigationView;
    private int PageFlag = 1;

    public static void startThisActivity(Activity activity, String loginAccount, String loginPassword,User user){
        Intent intent = new Intent(activity,MainActivity.class);
        intent.putExtra("loginAccount",loginAccount);
        intent.putExtra("loginPassword",loginPassword);
        intent.putExtra("user",user);
        activity.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //隐藏默认的顶部导航
        getSupportActionBar().hide();

        //获取底部导航视图实例
        bottomNavigationView = findViewById(R.id.bottomNavi);

        //把“发现”页作为主页
        getSupportFragmentManager().beginTransaction().replace(R.id.contentFrame,new DiscoverFragment()).commit();
        //注册底部导航按钮点击事件
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transition = getSupportFragmentManager().beginTransaction();

                switch (menuItem.getItemId()){
                    case R.id.bottomNavi_discover:
                        transition.replace(R.id.contentFrame,new DiscoverFragment()).commit();
                        PageFlag = 1;
                        break;
                    case R.id.bottomNavi_friends:
                        transition.replace(R.id.contentFrame,new FriendFragment()).commit();
                        PageFlag = 2;
                        break;
                    case R.id.bottomNavi_communicate:
                        transition.replace(R.id.contentFrame,new CommunicateFragment()).commit();
                        PageFlag = 3;
                        break;
                    case R.id.bottomNavi_myself:
                        transition.replace(R.id.contentFrame,new MeFragment()).commit();
                        PageFlag = 4;
                        break;
                }
                return true;
            }
        });

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState!=null){
            PageFlag = savedInstanceState.getInt("KEY_PAGE_INDEX");
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            switch (PageFlag){
                case 1:
                    transaction.replace(R.id.contentFrame,new DiscoverFragment()).commit();
                    PageFlag = 1;
                    break;
                case 3:
                    transaction.replace(R.id.contentFrame,new CommunicateFragment()).commit();
                    PageFlag = 3;
                    break;
                case 4:
                    transaction.replace(R.id.contentFrame,new MeFragment()).commit();
                    PageFlag = 4;
                    break;
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("KEY_PAGE_INDEX",PageFlag);

    }
}
