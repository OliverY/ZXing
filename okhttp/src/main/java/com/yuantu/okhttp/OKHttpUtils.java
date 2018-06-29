package com.yuantu.okhttp;

import android.util.Log;
import android.webkit.WebView;

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
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request originalRequest = chain.request();
//                        HttpUrl httpUrl = request.url();
//                        httpUrl.

                        Log.i("yxj","contentType::"+originalRequest);

                        String token = "";

                        Request updateRequest = originalRequest.newBuilder()
                                .header("token",token)
                                .build();

//                        ResponseBody.create("text/");
//
//                        new Response.Builder()
//                                .body()

                        Log.i("yxj","拦截request 1");
                        Response response = chain.proceed(originalRequest);
                        Log.i("yxj","拦截response 1");
                        return response;
                    }
                })
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Log.i("yxj","拦截request 2");
                        Response response = chain.proceed(request);
                        Log.i("yxj","拦截response 2");

                        BufferedSource source = response.body().source();
                        source.request(Long.MAX_VALUE);
                        Buffer buffer = source.buffer();
                        Log.i("yxj","responseStr="+buffer.clone().readString(Charset.forName("UTF-8")));

//                        String responseStr = new String(response.body().bytes());
//                        Log.i("yxj","responseStr="+responseStr);
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

    public void login(Callback callback){
        String url = "https://route-uat.yuantutech.com/user-web/restapi/common/ytDoctors/loginNew?phoneNum=18848958292&password=e10adc3949ba59abbe56e057f20f883e&unionId=29";

        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);

    }
}
