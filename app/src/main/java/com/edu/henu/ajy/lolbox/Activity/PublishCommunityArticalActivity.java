package com.edu.henu.ajy.lolbox.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.edu.henu.ajy.lolbox.Layouts.TitleLayout;
import com.edu.henu.ajy.lolbox.Page.CommuAllPage;
import com.edu.henu.ajy.lolbox.R;
import com.edu.henu.ajy.lolbox.Utils.HttpUtil;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PublishCommunityArticalActivity extends AppCompatActivity {

    public static void startThisActivity(Activity activity,String account){
        Intent intent = new Intent(activity, PublishCommunityArticalActivity.class);
        intent.putExtra("loginAccount",account);
        activity.startActivity(intent);
    }

    private static String DEF="1";
    private String content_imgPath="";
    private String artical_cate="综合频道";
    private String artical_time="两天前";
    private String like_count="0";
    private String comment_count = "0";
    private String userAccount;
    private EditText titleE,contentE;
    private TitleLayout topBar;
    private Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_community_artical);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        userAccount = intent.getStringExtra("loginAccount");
        titleE = findViewById(R.id.title);

        calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        topBar = findViewById(R.id.topBar);
        topBar.setTitle("发表帖子");
        topBar.setTitleGravity(Gravity.CENTER);
        topBar.setBackVisible(View.VISIBLE);
        topBar.hideForward();
        topBar.showSendBtn();
        contentE = findViewById(R.id.content);
        topBar.getSend().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleE.getText().toString();
                String content = contentE.getText().toString();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH)+1;
                int day = calendar.get(Calendar.DATE);
                artical_time=year+"-"+month+"-"+day;
                RequestBody body = new FormBody.Builder()
                        .add("def", DEF)
                        .add("title", title)
                        .add("content", content)
                        .add("content_imgPath", content_imgPath)
                        .add("artical_cate", artical_cate)
                        .add("artical_time", artical_time)
                        .add("comment_count", comment_count)
                        .add("like_count", like_count)
                        .add("userAccount", userAccount)
                        .build();

                HttpUtil.publishCommunity(body, MainActivity.PUBLISHCOMMUNITY, DEF, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(PublishCommunityArticalActivity.this, "连接服务器失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String res = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (res.equals("true")) {
                                    Toast.makeText(PublishCommunityArticalActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
                                    finish();
                                } else {
                                    Toast.makeText(PublishCommunityArticalActivity.this, "发送失败", Toast.LENGTH_SHORT).show();
                                    finish();
                                }

                            }
                        });
                    }
                });
            }
        });
    }
}