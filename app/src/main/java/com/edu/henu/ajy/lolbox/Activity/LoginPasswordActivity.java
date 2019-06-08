package com.edu.henu.ajy.lolbox.Activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.henu.ajy.lolbox.Layouts.TitleLayout;
import com.edu.henu.ajy.lolbox.Models.User;
import com.edu.henu.ajy.lolbox.Utils.DBHelper;
import com.edu.henu.ajy.lolbox.Utils.HttpUtil;
import com.edu.henu.ajy.lolbox.R;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LoginPasswordActivity extends AppCompatActivity {

    public static void startThisActivity(Activity activity,String loginAccount){
        Intent intent = new Intent(activity,LoginPasswordActivity.class);
        intent.putExtra("loginAccount",loginAccount);
        activity.startActivity(intent);
    }
    String loginAccount;
    String loginPassword;
    EditText loginPasswordE;
    private DBHelper dbHelper;
    private User user=null;
    private TitleLayout topBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_password);

        getSupportActionBar().hide();
        topBar = findViewById(R.id.topBar);
        topBar.setBackImage(R.drawable.ic_back_in_login);
        topBar.hideForward();
        topBar.hideTitle();
        topBar.hideOperate();
        topBar.showBack();
        topBar.hideBottomBlackLine();

        Intent intent = getIntent();
        loginAccount = intent.getStringExtra("loginAccount");
        loginPasswordE = findViewById(R.id.loginPassword);
        Button loginSubmit = findViewById(R.id.loginSubmit);
        dbHelper = new DBHelper(LoginPasswordActivity.this,"User.db",null,LoginAccountActivity.DBUSER_VERSION);
        loginSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPassword = loginPasswordE.getText().toString();
                HttpUtil.loginUtil(loginAccount, loginPassword, MainActivity.LOGINSERVER, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginPasswordActivity.this,"服务器无响应",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String res = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                loginResult(res);
                            }
                        });
                    }
                });
            }
        });
    }
    public void loginResult(String res){
        Gson gson = new Gson();
        user = gson.fromJson(res,User.class);
        if (user!=null){
            Toast.makeText(LoginPasswordActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
            MainActivity.startThisActivity(LoginPasswordActivity.this,loginAccount,loginPassword,user);

            //若登录成功，则先清空User表，加入新登录的用户数据，始终保持User表只有一条数据
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL("delete from User");
            ContentValues values = new ContentValues();
            values.put("userAccount",user.getAccount());
            values.put("userPassword",user.getPassword());
            values.put("headImgPath",user.getHeadImgPath());
            values.put("uname",user.getUname());
            values.put("level",user.getLevel());
            values.put("focus",user.getFocus());
            values.put("fans",user.getFans());
            values.put("thumbsup",user.getThumbs());
            db.insert("User",null,values);

        }else{
            Toast.makeText(LoginPasswordActivity.this,"账号或密码有误",Toast.LENGTH_SHORT).show();
        }
    }
}
