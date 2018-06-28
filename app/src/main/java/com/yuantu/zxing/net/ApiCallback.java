package com.yuantu.zxing.net;

import com.google.gson.Gson;
import com.yuantu.zxing.net.bean.ApiResponse;
import com.zhy.http.okhttp.callback.Callback;
import okhttp3.Response;

/**
 * Author:  Yxj
 * Time:    2018/6/28 下午2:22
 * -----------------------------------------
 * Description:
 */
public abstract class ApiCallback extends Callback<ApiResponse> {

    @Override
    public ApiResponse parseNetworkResponse(Response response, int id) throws Exception {
        Gson gson = new Gson();
        return gson.fromJson(response.body().string(),ApiResponse.class);
    }

}
