package com.yuantu.zxing.net.callback;

/**
 * Author:  Yxj
 * Time:    2018/7/2 上午9:09
 * -----------------------------------------
 * Description:
 */
public abstract class ObjectCallback<T> extends ApiCallback {

    public abstract T parseJsonObject(String json);

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
