package com.yuantu.zxing.net;

import android.util.Log;

import com.google.gson.Gson;
import com.yuantu.zxing.bean.Product;
import com.yuantu.zxing.net.callback.ApiCallback;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.MediaType;

/**
 * Author:  Yxj
 * Time:    2018/6/28 下午1:34
 * -----------------------------------------
 * Description:
 */
public class Api {

    private static final String BASE_URL = "http://ngrok.yuantutech.com:65000/jszx";

    public static void query(String id,StringCallback callback){
        String url = BASE_URL+"/product/query";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("barcode",id)
                .build()
                .execute(callback);
    }

    /**
     * 绑定
     * @param product
     * @param callback
     */
    public static void bind(Product product,StringCallback callback){
        String url = BASE_URL+"/product/bind";
        Gson gson = new Gson();
        String json = gson.toJson(product);

        Log.e("yxj","json="+json);

        OkHttpUtils
                .postString()
                .url(url)
                .content(json)
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(callback);
    }

    /**
     * 登录
     * @param email
     * @param password
     * @param callback
     */
    public static void login(String email,String password,ApiCallback callback){
//        /user/login?email=&password=
        OkHttpUtils
                .get()
                .url("")
                .build()
                .execute(callback);
    }

}
