package com.edu.henu.ajy.lolbox.Utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.edu.henu.ajy.lolbox.Activity.MainActivity;
import com.edu.henu.ajy.lolbox.Activity.ShowContentActivity;
import com.edu.henu.ajy.lolbox.Models.CommunicateItem;
import com.edu.henu.ajy.lolbox.Models.MeScoreItem;
import com.edu.henu.ajy.lolbox.Page.MeFightScorePage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtil {
    public static void getJsonArray(String address, String defCode, Callback callback){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("defCode",defCode)
                .build();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }

    public static void getJsonObject(String address,String account,Callback callback){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("account",account)
                .build();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }

    //执行登录操作
    public static void loginUtil(String loginAccount,String loginPassword,String address,Callback callback){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("loginAccount",loginAccount)
                .add("loginPassword",loginPassword)
                .build();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }
    //执行注册操作
    public static void registerUtil(RequestBody body,String address,Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }
    //发布帖子
    public static void publishCommunity(RequestBody body,String address,String def,Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }
    //给ImageView设置背景
    public static void setImg(final Activity activity, final ImageView imageView, String address, String imgName){
        getJsonArray(address + imgName, "", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream in = response.body().byteStream();
                final Bitmap bitmap= BitmapFactory.decodeStream(in);
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });

            }
        });
    }
    //查询战绩
    public static void setScoreList(final MeFightScorePage fightScorePage, String address,String account){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("account",account)
                .build();
        final Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string();
                fightScorePage.initList(data);
            }
        };
        client.newCall(request).enqueue(callback);

    }
    //加载评论列表
    public static void loadComments(final ShowContentActivity showContent, String address, int articalId){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("articalId", String.valueOf(articalId))
                .build();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("COmmentRequest","失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonData = response.body().string();

                Gson gson = new Gson();
                final List<CommunicateItem> comments = gson.fromJson(jsonData,new TypeToken<List<CommunicateItem>>(){}.getType());
                showContent.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showContent.loadCommentList(comments);
                    }
                });
            }
        };
        client.newCall(request).enqueue(callback);
    }
    //添加评论
    public static void sendComment(final ShowContentActivity showContent, String address, final int articalId, String comment, String articalAccount, String commentAccount){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("articalId", String.valueOf(articalId))
                .add("comment",comment)
                .add("articalAccount",articalAccount)
                .add("commentAccount",commentAccount)
                .build();

        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("COmmentRequest","失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonData = response.body().string();
                if (jsonData.equals("true")){
                    loadComments(showContent, MainActivity.GETCOMMENTS,articalId);
                }
            }
        };
        client.newCall(request).enqueue(callback);
    }
}
