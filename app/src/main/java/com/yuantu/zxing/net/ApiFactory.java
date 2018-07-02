package com.yuantu.zxing.net;

import com.yuantu.zxing.net.callback.ApiCallback;
import com.yuantu.zxing.net.service.ApiService;

/**
 * Author:  Yxj
 * Time:    2018/7/2 上午11:38
 * -----------------------------------------
 * Description:
 */
public class ApiFactory {

    public static ApiService getApiService() {
        return RetrofitClient.getInstance().getRetrofit().create(ApiService.class);
    }

    public static void query(String barCode,ApiCallback callback) {
        getApiService().query(barCode).enqueue(callback);
    }
}
