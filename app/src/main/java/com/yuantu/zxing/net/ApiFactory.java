package com.yuantu.zxing.net;

import com.google.gson.Gson;
import com.yuantu.zxing.bean.Product;
import com.yuantu.zxing.net.callback.ApiCallback;
import com.yuantu.zxing.net.service.ApiService;

import okhttp3.RequestBody;

/**
 * Author:  Yxj
 * Time:    2018/7/2 上午11:38
 * -----------------------------------------
 * Description:
 */
public class ApiFactory {

    private static ApiService getApiService() {
        return RetrofitClient.getInstance().getRetrofit().create(ApiService.class);
    }

    public static void query(String barCode,ApiCallback callback) {
        getApiService().query(barCode).enqueue(callback);
    }

    public static void bind(Product product,ApiCallback callback){
        getApiService().bind(product).enqueue(callback);
    }
}
