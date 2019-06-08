package com.edu.henu.ajy.lolbox.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.henu.ajy.lolbox.Layouts.TitleLayout;
import com.edu.henu.ajy.lolbox.Models.User;
import com.edu.henu.ajy.lolbox.R;
import com.edu.henu.ajy.lolbox.Utils.HttpUtil;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

    private EditText loginAccountE;
    private EditText loginPasswordE;
    private EditText unameE;
    private EditText emailE;
    private Button registerSubmit;
    private String registeAccount;
    private String registePassword;
    private String uname;
    private String email;
    private TitleLayout topBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        topBar = findViewById(R.id.topBar);
        topBar.setBackImage(R.drawable.ic_appbar_back);
        topBar.hideForward();
        topBar.setTitle("用户注册");
        topBar.setTitleGravity(Gravity.CENTER);
        topBar.hideOperate();
        topBar.showBack();

        loginAccountE = findViewById(R.id.loginAccount);
        loginPasswordE = findViewById(R.id.loginPassword);
        unameE = findViewById(R.id.uname);
        emailE = findViewById(R.id.email);
        registerSubmit = findViewById(R.id.registerSubmit);
        registerSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registeAccount = loginAccountE.getText().toString();
                registePassword = loginPasswordE.getText().toString();
                uname = unameE.getText().toString();
                email = emailE.getText().toString();
                //执行注册操作
                User user = new User(uname,email,registeAccount,registePassword);
                register(user);
            }
        });
    }

    public void register(User user){
        RequestBody body = new FormBody.Builder()
                .add("registerAccount",user.getAccount())
                .add("registerPassword",user.getPassword())
                .add("uname",user.getUname())
                .add("email",user.getEmail())
                .build();
        HttpUtil.registerUtil(body, MainActivity.REGISTERSERVER, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(RegisterActivity.this,"网络错误",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String res = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        User user = gson.fromJson(res,User.class);
                        if (user!=null){
                            Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                            //注册成功后，直接自动登录
                            MainActivity.startThisActivity(RegisterActivity.this,registeAccount,registePassword,user);
                        }else {
                            Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}
