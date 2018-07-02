package com.yuantu.zxing.net.callback;


import com.yuantu.zxing.net.bean.ApiResponse;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author:  Yxj
 * Time:    2018/6/30 上午11:00
 * -----------------------------------------
 * Description:
 */
public abstract class ApiCallback<T> implements Callback<ApiResponse> {

    public abstract void onSuccess(T t);

    public abstract void onFailed(String msg);

    @Override
    public void onResponse(retrofit2.Call<ApiResponse> call, Response<ApiResponse> response) {
        ApiResponse apiResponse = response.body();
        if(apiResponse.isSuccess()){
            T t = (T) apiResponse.getData();
            onSuccess(t);
        }else{
            onFailed(apiResponse.getMsg());
        }
    }

    @Override
    public void onFailure(retrofit2.Call<ApiResponse> call, Throwable t) {
        onFailed(t.getMessage());
    }
}
