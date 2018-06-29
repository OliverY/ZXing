package com.yuantu.zxing.net;


import android.util.Log;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Author:  Yxj
 * Time:    2018/6/27 下午11:06
 * -----------------------------------------
 * Description:
 */
public class LoggingInterceptor implements Interceptor {

    private static final String TAG = LoggingInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Log.i("yxj", "request::"+request.url().toString());
        Response response = chain.proceed(request);

        BufferedSource source = response.body().source();
        source.request(Long.MAX_VALUE);
        Buffer buffer = source.buffer();
        Log.i("yxj", "response::" + buffer.clone().readString(Charset.forName("UTF-8")));

        return response;
    }
}
