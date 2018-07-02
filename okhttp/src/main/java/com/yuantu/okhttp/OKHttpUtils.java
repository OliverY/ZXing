package com.yuantu.okhttp;

import android.util.Log;
import android.webkit.WebView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Author:  Yxj
 * Time:    2018/6/28 下午10:54
 * -----------------------------------------
 * Description:
 */
public class OKHttpUtils {

    private final OkHttpClient client;

    private OKHttpUtils(){
        client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Response response = chain.proceed(chain.request());

                        BufferedSource source = response.body().source();
                        source.request(Long.MAX_VALUE);
                        Buffer buffer = source.buffer();
                        Log.i("yxj","responseStr="+buffer.clone().readString(Charset.forName("UTF-8")));

                        return response;
                    }
                })
                .build();
    }

    public interface Holder{
        OKHttpUtils instance = new OKHttpUtils();
    }

    public static OKHttpUtils getInstance(){
        return Holder.instance;
    }

    public void login(ObjCallback callback){
        String url = "https://route-uat.yuantutech.com/user-web/restapi/common/ytDoctors/loginNew?phoneNum=18848958292&password=e10adc3949ba59abbe56e057f20f883e&unionId=29";

//        Request request = new Request.Builder()
//                .get()
//                .url(url)
//                .build();
//        Call call = client.newCall(request);
//        call.enqueue(callback);

        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = client.newCall(request);
//        call.enqueue(callback);

        call.enqueue(new ApiCallback<ApiResponse<LoginBean>>(new ApiCallback.Callback<ApiResponse<LoginBean>>() {
            @Override
            public void onSuccess(ApiResponse<LoginBean> apiResponse) {
                Log.e("yxj",apiResponse.toString());
            }

            @Override
            public void onFailed(String msg) {

            }
        }));

//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String result = response.body().string();
//                Gson gson = new Gson();
//                ApiResponse<LoginBean> apiResponse = gson.fromJson(result,new TypeToken<ApiResponse<LoginBean>>(){}.getType());
//                LoginBean loginBean = apiResponse.getData();
//                apiResponse.isSuccess();
//
//
//            }
//        });
    }


}
