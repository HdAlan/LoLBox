package com.edu.henu.ajy.lolbox;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

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
}
