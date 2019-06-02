package com.edu.henu.ajy.lolbox.Utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtil {
    public static void getJsonArray(String address,String defCode, Callback callback){
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

    public static void registerUtil(RequestBody body,String address,Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }

    public static void publishCommunity(RequestBody body,String address,String def,Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }

    public static void getImgBitmap(final Activity activity, final ImageView imageView, String address, String imgName){
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
}
