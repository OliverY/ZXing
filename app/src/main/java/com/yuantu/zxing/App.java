package com.yuantu.zxing;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Author:  Yxj
 * Time:    2018/6/28 上午11:03
 * -----------------------------------------
 * Description:
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor("yxj"))
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .cookieJar(new CookieJarImpl(new PersistentCookieStore(this)))
                .build();

        OkHttpUtils.initClient(client);
    }
}
