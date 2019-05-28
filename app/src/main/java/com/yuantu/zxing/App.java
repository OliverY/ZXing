package com.yuantu.zxing;

import android.app.Application;

import com.yuantu.zxing.net.RetrofitClient;

/**
 * Author:  Yxj
 * Time:    2018/6/28 上午11:03
 * -----------------------------------------
 * Description:
 */
public class App extends Application {

    public static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

        RetrofitClient.getInstance().init(getApplicationContext());
    }


}
