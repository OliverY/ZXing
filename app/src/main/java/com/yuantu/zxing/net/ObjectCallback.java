//package com.yuantu.zxing.net;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import com.yuantu.zxing.net.bean.ApiResponse;
//import com.yuantu.zxing.net.bean.ProductBean;
//import com.zhy.http.okhttp.callback.StringCallback;
//
//import okhttp3.Call;
//
///**
// * Author:  Yxj
// * Time:    2018/6/28 下午2:01
// * -----------------------------------------
// * Description:
// */
//public abstract class ObjectCallback<T extends Object> extends StringCallback {
//
//    public abstract Callback<T> getCallback();
//
//    @Override
//    public void onError(Call call, Exception e, int id) {
//        getCallback().onError(e.getMessage());
//    }
//
//    @Override
//    public void onResponse(String response, int id) {
//        Gson gson = new Gson();
//        ApiResponse apiResponse = gson.fromJson(response,ApiResponse.class);
//        if(apiResponse.isSuccess()){
//            T t = gson.fromJson(apiResponse.getData(),new TypeToken<T>(){}.getType());
//            getCallback().onResponse(t);
//        }else{
//            getCallback().onError(apiResponse.getMsg());
//        }
//    }
//
//    public interface Callback<T>{
//        void onResponse(T t);
//        void onError(String msg);
//    }
//}
