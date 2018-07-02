package com.yuantu.zxing.net.callback;


import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;

/**
 * Author:  Yxj
 * Time:    2018/6/30 上午11:00
 * -----------------------------------------
 * Description:
 */
public abstract class ApiCallback extends StringCallback {

    public abstract void onSuccess(String jsonStr);

    public abstract void onFailed(String msg);

    @Override
    public void onError(Call call, Exception e, int id) {
        onFailed(e.getMessage());
    }

    @Override
    public void onResponse(String response, int id) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            boolean success = jsonObject.getBoolean("success");
            if(success){
                onSuccess(jsonObject.getString("data"));
            }else {
                onFailed(jsonObject.getString("msg"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            onFailed(e.getMessage());
        }
    }

}
