package com.yuantu.okhttp;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Author:  Yxj
 * Time:    2018/7/2 上午10:13
 * -----------------------------------------
 * Description:
 */
public class ApiCallback<T> implements Callback {

    Callback<T> callback;

    public ApiCallback(Callback<T> callback) {
        this.callback = callback;
    }

    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        String result = response.body().string();
        Gson gson = new Gson();
        Type type = new TypeToken<ApiResponse<T>>(){}.getType();
        T t = gson.fromJson(result,type);
        callback.onSuccess(t);
    }

    public interface Callback<T>{
        void onSuccess(T t);
        void onFailed(String msg);
    }
}
