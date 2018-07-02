package com.yuantu.zxing.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
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

    private static final String BASE_URL = "http://120.55.185.136:8090/jszx/";
    private Retrofit retrofit;

    private RetrofitClient(){
    }

    interface Holder{
        RetrofitClient instance = new RetrofitClient();
    }

    public static RetrofitClient getInstance(){
        return Holder.instance;
    }

    private OkHttpClient createOkHttpClient(){
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        return new OkHttpClient.Builder()
                .addNetworkInterceptor(logInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .build();
    }

    public void init(){
        retrofit = new Retrofit.Builder()
                .client(createOkHttpClient())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

}
