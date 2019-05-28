package com.yuantu.zxing.net;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author:  Yxj
 * Time:    2018/7/2 上午11:15
 * -----------------------------------------
 * Description:
 */
public class RetrofitClient {

    public static String BASE_URL = "http://120.55.185.136:8080/jszx/";//生产
//    public static String BASE_URL = "http://120.55.185.136:8090/jszx/";//测试
    private Retrofit retrofit;

    private RetrofitClient(){
    }

    interface Holder{
        RetrofitClient instance = new RetrofitClient();
    }

    public static RetrofitClient getInstance(){
        return Holder.instance;
    }

    private OkHttpClient createOkHttpClient(Context context){
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addNetworkInterceptor(logInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .cookieJar(new CookieJarImpl(new PersistentCookieStore(context)))
                .build();
    }

    public void init(Context context){
        retrofit = new Retrofit.Builder()
                .client(createOkHttpClient(context))
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

}
