package com.yuantu.zxing.net;

import retrofit2.Retrofit;

/**
 * Author:  Yxj
 * Time:    2018/7/2 上午11:15
 * -----------------------------------------
 * Description:
 */
public class RetrofitClient {

    private static final String BASE_URL = "http://120.55.185.136:8090/jszx";

    public void fun(){



        new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build();
    }

}
