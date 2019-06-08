package com.edu.henu.ajy.lolbox.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.henu.ajy.lolbox.Adapter.CommuListAdapter;
import com.edu.henu.ajy.lolbox.Layouts.TitleLayout;
import com.edu.henu.ajy.lolbox.Models.CommunicateItem;
import com.edu.henu.ajy.lolbox.Models.User;
import com.edu.henu.ajy.lolbox.Utils.HttpUtil;
import com.edu.henu.ajy.lolbox.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ShowContentActivity extends AppCompatActivity implements View.OnClickListener {


    public static void startThisActivity(Activity activity, CommunicateItem item, User user) {
        Intent intent = new Intent(activity, ShowContentActivity.class);
        intent.putExtra("item", item);
        intent.putExtra("user",user);
        activity.startActivity(intent);
    }

    TextView titleText;
    TextView authorText;
    TextView contentText;
    ImageView image;
    private EditText commentText;
    private LinearLayout CommentBoard, thumbupBtn, commentBtn;
    private TitleLayout Bar;
    private TextView sendComment;
    private EditText commentE;
    private List<CommunicateItem> comments = new ArrayList<>();
    private CommuListAdapter commentAdapter;
    private ListView commentList;
    private InputMethodManager methodManager;
    private User user;
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

//        titleText = findViewById(R.id.title);
//        authorText = findViewById(R.id.author);
//        contentText = findViewById(R.id.content);
//        image = findViewById(R.id.image);
        commentText = findViewById(R.id.commentText);
        methodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//        CommentBoard = findViewById(R.id.CommentBoard);
        sendComment = findViewById(R.id.sendComment);
//        commentE = findViewById(R.id.commentE);
        thumbupBtn = findViewById(R.id.thumbupBtn);
        commentBtn = findViewById(R.id.commentBtn);
        commentList = findViewById(R.id.commentsList);
        commentText.setOnClickListener(this);
        sendComment.setOnClickListener(this);
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("user");
        CommunicateItem item = (CommunicateItem) intent.getSerializableExtra("item");
//        titleText.setText(item.getTitle());
//        authorText.setText(item.getUserName());
//        contentText.setText(item.getSummary());
//        setImageContent(item.getArticalImgPath());
        comments.add(item);
        commentAdapter = new CommuListAdapter(this, comments, false);
        commentList.setAdapter(commentAdapter);
        HttpUtil.loadComments(this,MainActivity.GETCOMMENTS,item.getId());
    }

    public void setImageContent(String imagepath) {
        HttpUtil.getJsonArray(MainActivity.PICTUREPATHPRE + imagepath, "", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ShowContentActivity.this, "请求图片失败", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.commentText:
                expendCommentBoard();
                break;
            case R.id.sendComment:
                CommunicateItem artical = comments.get(0);
                //Log.d("comment",commentText.getText().toString());
                String comment = commentText.getText().toString();
                contractCommentBoard();
                HttpUtil.sendComment(this,MainActivity.SENDCOMMENT,artical.getId(),comment,artical.getUserAccount(),user.getAccount());
                break;
        }
    }

    public void expendCommentBoard() {
        commentText.setFocusable(true);
        commentText.setFocusableInTouchMode(true);
        commentText.setLines(3);
        commentText.setBackgroundResource(R.color.colorWhite);
        thumbupBtn.setVisibility(View.GONE);
        commentBtn.setVisibility(View.GONE);
        sendComment.setVisibility(View.VISIBLE);
        methodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void contractCommentBoard() {
        commentText.setFocusable(false);
        commentText.setFocusableInTouchMode(false);
        commentText.setLines(1);
        commentText.setBackgroundResource(R.color.colorLowGray);
        thumbupBtn.setVisibility(View.VISIBLE);
        commentBtn.setVisibility(View.VISIBLE);
        sendComment.setVisibility(View.GONE);
        commentText.setText("");

        methodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void loadCommentList(List<CommunicateItem> comments) {
        this.comments.addAll(comments);
        commentAdapter.notifyDataSetChanged();
    }
}