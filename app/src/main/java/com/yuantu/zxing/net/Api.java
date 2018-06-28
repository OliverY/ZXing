package com.yuantu.zxing.net;

import com.google.gson.Gson;
import com.yuantu.zxing.bean.Product;
import com.zhy.http.okhttp.OkHttpUtils;

/**
 * Author:  Yxj
 * Time:    2018/6/28 下午1:34
 * -----------------------------------------
 * Description:
 */
public class Api {

    public static <T> void query(String id,ObjectCallback.Callback<T> callback){
//        "http://ngrok.yuantutech.com:65000/jszx/"

        OkHttpUtils
                .get()
                .url("product/query?barcode=1-001-002-20180627-001")
                .addParams("barcode",id)
                .build()
                .execute(new ObjectCallback(){
                    @Override
                    public Callback getCallback() {
                        return callback;
                    }
                });
    }

    /**
     * 绑定
     * @param product
     * @param callback
     */
    public static void bind(Product product,ApiCallback callback){
        Gson gson = new Gson();
        String json = gson.toJson(product);
        OkHttpUtils
                .post()
                .url("")
                .addParams("productBindRequest",json)
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
