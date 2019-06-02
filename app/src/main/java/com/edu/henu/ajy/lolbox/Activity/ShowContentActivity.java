package com.edu.henu.ajy.lolbox.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.henu.ajy.lolbox.Layouts.TitleLayout;
import com.edu.henu.ajy.lolbox.Utils.HttpUtil;
import com.edu.henu.ajy.lolbox.R;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ShowContentActivity extends AppCompatActivity {

    public static void startThisActivity(Activity activity, String title, String author, String content, String imagepath){
        Intent intent = new Intent(activity,ShowContentActivity.class);
        intent.putExtra("Bar",title);
        intent.putExtra("author",author);
        intent.putExtra("content",content);
        intent.putExtra("imagepath",imagepath);
        activity.startActivity(intent);
    }

    TextView titleText;
    TextView authorText;
    TextView contentText;
    ImageView image;
    private TitleLayout Bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_content);
        getSupportActionBar().hide();
        Bar = findViewById(R.id.actionBar);
        Bar.setTitle("详情");
        Bar.setBackVisible(View.VISIBLE);
        Bar.setTitleGravity(Gravity.CENTER);
        Bar.hideForward();

        titleText = findViewById(R.id.title);
        authorText = findViewById(R.id.author);
        contentText = findViewById(R.id.content);
        image = findViewById(R.id.image);

        Intent intent = getIntent();
        String title = intent.getStringExtra("Bar");
        String author = intent.getStringExtra("author");
        String content = intent.getStringExtra("content");
        String imagepath = intent.getStringExtra("imagepath");
        titleText.setText(title);
        authorText.setText(author);
        contentText.setText(content);
        setImageContent(imagepath);

    }

    public void setImageContent(String imagepath){
        HttpUtil.getJsonArray(MainActivity.PICTUREPATHPRE+imagepath,"", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ShowContentActivity.this,"请求图片失败",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream os = response.body().byteStream();
                final Bitmap bitmap = BitmapFactory.decodeStream(os);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        image.setImageBitmap(bitmap);
                    }
                });
            }
        });
    }
}