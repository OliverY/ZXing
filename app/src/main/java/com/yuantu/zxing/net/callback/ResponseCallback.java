package com.yuantu.zxing.net.callback;

import com.google.gson.Gson;
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
public abstract class ResponseCallback extends StringCallback {

    @Override
    public void onError(Call call, Exception e, int id) {
        getCallback().onError(e.getMessage());
    }

    @Override
    public void onResponse(String response, int id) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            boolean success = jsonObject.getBoolean("success");
            if(success){
                getCallback().onResponse(jsonObject.getString("data"));
            }else {
                getCallback().onError(jsonObject.getString("msg"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            getCallback().onError(e.getMessage());
        }
    }

    protected abstract Callback getCallback();

    public interface Callback{
        void onResponse(String jsonStr);
        void onError(String msg);
    }

}
