package com.yuantu.zxing.net;


import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

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
        long t1 = System.nanoTime();
        Request request = chain.request();
        Log.i(TAG,String.format("request:: %s on %s%n%s", request.url(),chain.connection(),request.headers()));

        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        Log.i(TAG,String.format("response:: %s in %.1fms%n%s", request.url(),(t2-t1)/1e6d,request.headers()));

        return response;
    }
}
