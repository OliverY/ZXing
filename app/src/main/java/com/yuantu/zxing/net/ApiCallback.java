package com.yuantu.zxing.net;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;

/**
 * Author:  Yxj
 * Time:    2018/6/28 下午2:22
 * -----------------------------------------
 * Description:
 */
public abstract class ApiCallback<T> extends StringCallback {

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
                Gson gson = new Gson();
                T t = gson.fromJson(jsonObject.getString("data"),new TypeToken<T>(){}.getType());
                getCallback().onResponse(t);
            }else {
                getCallback().onError(jsonObject.getString("msg"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            getCallback().onError(e.getMessage());
        }
    }

    protected abstract Callback<T> getCallback();

    public interface Callback<T>{
        void onResponse(T t);
        void onError(String msg);
    }

}
