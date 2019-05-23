package com.edu.henu.ajy.lolbox.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.henu.ajy.lolbox.Utils.HttpUtil;
import com.edu.henu.ajy.lolbox.R;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_password);

        Intent intent = getIntent();
        loginAccount = intent.getStringExtra("loginAccount");
        loginPasswordE = findViewById(R.id.loginPassword);
        Button loginSubmit = findViewById(R.id.loginSubmit);
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
                                Toast.makeText(LoginPasswordActivity.this,"网络错误",Toast.LENGTH_SHORT).show();
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
        if (res.equals("true")){
            Toast.makeText(LoginPasswordActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
            MainActivity.startThisActivity(LoginPasswordActivity.this,loginAccount,loginPassword);
        }else{
            Toast.makeText(LoginPasswordActivity.this,"账号或密码有误",Toast.LENGTH_SHORT).show();
        }
    }
}
