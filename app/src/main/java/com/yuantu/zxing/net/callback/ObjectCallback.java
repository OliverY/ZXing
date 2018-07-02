package com.yuantu.zxing.net.callback;

import com.google.gson.Gson;

/**
 * Author:  Yxj
 * Time:    2018/7/2 上午9:09
 * -----------------------------------------
 * Description:
 */
public abstract class ObjectCallback<T> extends ApiCallback {

    private Class<T> clazz;

    public ObjectCallback(Class<T> clazz) {
        this.clazz = clazz;
    }

    private T parseJsonObject(String json){
        return new Gson().fromJson(json, clazz);
    }

    @Override
    public void onSuccess(String jsonStr) {
        T t = parseJsonObject(jsonStr);
        onObjectSuccess(t);
    }

    @Override
    public void onFailed(String msg) {
        onObjectFailed(msg);
    }

    public abstract void onObjectSuccess(T t);
    public abstract void onObjectFailed(String msg);
}
