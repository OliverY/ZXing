package com.yuantu.zxing.net;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yuantu.zxing.net.bean.ApiResponse;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Author:  Yxj
 * Time:    2018/6/28 下午2:01
 * -----------------------------------------
 * Description: 功能与ObjectCallback重叠，暂时不用
 */
public abstract class NewObjectCallback<T> extends Callback<T> {

    @Override
    public T parseNetworkResponse(Response response, int id) {
        T t = null;
        try {
            Gson gson = new Gson();
            ApiResponse apiResponse = gson.fromJson(response.body().string(),ApiResponse.class);
            if(apiResponse.isSuccess()){
                t = gson.fromJson(apiResponse.getData(),new TypeToken<T>(){}.getType());
            }else{
                getCallback().onError(apiResponse.getMsg());
            }
        } catch (IOException e) {
            e.printStackTrace();
            getCallback().onError(e.getMessage());
        }
        return t;
    }

    @Override
    public void onResponse(T t, int id) {
        getCallback().onResponse(t);
    }

    @Override
    public void onError(Call call, Exception e, int id) {
        getCallback().onError(e.toString());
    }

    public abstract Callback<T> getCallback();

    public interface Callback<T>{
        void onResponse(T t);
        void onError(String msg);
    }
}
