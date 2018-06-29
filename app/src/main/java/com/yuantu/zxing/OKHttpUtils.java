package com.yuantu.zxing;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Author:  Yxj
 * Time:    2018/6/27 下午3:24
 * -----------------------------------------
 * Description:
 */
public class OKHttpUtils {


    public void init(){
        String url = "";
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        RequestBody requestBody = RequestBody.create();
        new Request.Builder();

        Request request = new Request.Builder()
                .url(url)
                .method("POST",requestBody)
                .addHeader()
                .cacheControl()
                .method()
                .build();
        Call call = okHttpClient.newCall(request);
        Response response  =call.execute();
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }


}
