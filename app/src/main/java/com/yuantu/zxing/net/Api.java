package com.yuantu.zxing.net;

import com.google.gson.Gson;
import com.yuantu.zxing.Product;
import com.yuantu.zxing.net.bean.ApiResponse;
import com.yuantu.zxing.net.bean.ProductBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;

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

}
