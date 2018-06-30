package com.yuantu.okhttp;


import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Author:  Yxj
 * Time:    2018/6/29 下午9:40
 * -----------------------------------------
 * Description:
 */
public abstract class ObjCallback<T> implements Callback {

    @Override
    public void onFailure(Call call, IOException e) {
        getListener().onFailed(e.getMessage());
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        ApiResponse<T> apiResponse = fromJson(new String(response.body().bytes()),getClazz());
        if(apiResponse.isSuccess()){
            getListener().onSuccess(apiResponse.getData());
        }else {
            getListener().onFailed(apiResponse.getMsg());
        }

//        Type type = new TypeToken<ApiResponse<type>>(){}.getType();
//        ApiResponse<T> apiResponse = new Gson().fromJson(new String(response.body().bytes()),type);
//        if(apiResponse.isSuccess()){
//            getListener().onSuccess(apiResponse.getData());
//        }else {
//            getListener().onFailed(apiResponse.getMsg());
//        }
    }

    public abstract Class<T> getClazz();

    public abstract Listener<T> getListener();

    interface Listener<T>{
        void onSuccess(T t);
        void onFailed(String msg);
    }

    public static ApiResponse fromJson(String json, Class clazz) {
        Gson gson = new Gson();
        Type objectType = type(ApiResponse.class, clazz);
        return gson.fromJson(json, objectType);
    }

    public String toJson(Class<T> clazz) {
        Gson gson = new Gson();
        Type objectType = type(ApiResponse.class, clazz);
        return gson.toJson(this, objectType);
    }

    static ParameterizedType type(final Class raw, final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return raw;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }
}
