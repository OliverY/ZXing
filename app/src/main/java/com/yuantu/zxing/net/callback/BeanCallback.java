package com.yuantu.zxing.net.callback;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import okhttp3.Call;

/**
 * Author:  Yxj
 * Time:    2018/6/28 下午2:22
 * -----------------------------------------
 * Description:
 */
public abstract class BeanCallback<T> extends ApiCallback {

    @Override
    protected Callback getCallback() {
        return new Callback() {
            @Override
            public void onResponse(String jsonStr) {
                Gson gson = new Gson();
                try {
                    T t = gson.fromJson(jsonStr,getBeanClass());
                    getObjCallback().onResponse(t);
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                    getObjCallback().onError("数据转换失败");
                }
            }

            @Override
            public void onError(String msg) {
                getObjCallback().onError(msg);
            }
        };
    }

    @Override
    public void onError(Call call, Exception e, int id) {
        super.onError(call, e, id);
    }

    /**
     * 获取bean的类型
     * @return
     */
    protected abstract Class<T> getBeanClass();

    protected abstract ObjCallback<T> getObjCallback();

    public interface ObjCallback<T>{
        void onResponse(T t);
        void onError(String msg);
    }

}
