package com.edu.henu.ajy.lolbox.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.edu.henu.ajy.lolbox.R;

public class LoginAccountActivity extends AppCompatActivity {
    private EditText loginAccountE;
    private TextView registerText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_account);

        loginAccountE = findViewById(R.id.loginAccount);
        Button nextStep = findViewById(R.id.nextStep);
        nextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginAccount = loginAccountE.getText().toString();
                LoginPasswordActivity.startThisActivity(LoginAccountActivity.this,loginAccount);
            }
        });

        registerText = findViewById(R.id.registerText);
        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginAccountActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
