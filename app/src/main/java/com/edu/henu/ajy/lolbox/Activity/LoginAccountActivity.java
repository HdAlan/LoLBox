package com.edu.henu.ajy.lolbox.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.edu.henu.ajy.lolbox.R;
import com.edu.henu.ajy.lolbox.Utils.DBHelper;

public class LoginAccountActivity extends AppCompatActivity {

    public static void startThisActivity(Activity activity){
        Intent intent = new Intent(activity,LoginAccountActivity.class);
        activity.startActivity(intent);
    }

    private EditText loginAccountE;
    private TextView registerText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_account);

        //刚启动应用时，检测User表是否有数据，尝试直接登录，若User表有数据，则直接登录，否则，需要输入账号密码。
        tryLoginWithOutInput();
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

    public void tryLoginWithOutInput(){
        DBHelper dbHelper = new DBHelper(LoginAccountActivity.this,"User.db",null,1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select*from User",null);
        if (cursor.moveToFirst()){
            String account = cursor.getString(cursor.getColumnIndex("userAccount"));
            String password = cursor.getString(cursor.getColumnIndex("userPassword"));
            MainActivity.startThisActivity(LoginAccountActivity.this,account,password);
        }
    }

}
