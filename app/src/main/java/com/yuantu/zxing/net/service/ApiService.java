package com.yuantu.zxing.net.service;

import com.yuantu.zxing.bean.ConfigBean;
import com.yuantu.zxing.bean.EquipmentBean;
import com.yuantu.zxing.bean.Product;
import com.yuantu.zxing.bean.SchedulerBean;
import com.yuantu.zxing.bean.SubmitBean;
import com.yuantu.zxing.net.ApiConstants;
import com.yuantu.zxing.net.bean.ApiResponse;
import com.yuantu.zxing.net.bean.ProductBean;
import com.yuantu.zxing.net.bean.ProductDetail;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Author:  Yxj
 * Time:    2018/7/2 上午11:33
 * -----------------------------------------
 * Description:
 */
public interface ApiService {

    @GET("product/query")
    Observable<ApiResponse<ProductBean>> query(@Query("barcode") String barCode);

    @POST("product/bind")
    Observable<ApiResponse> bind(@Body Product product);

    @GET("product/{id}")
    Observable<ApiResponse<ProductDetail>> queryChildDevices(@Path("id") int id);

    @GET("material/query")
    Observable<ApiResponse<ProductBean>> queryMaterial(@Query("barcode") String barCode);


    @POST(ApiConstants.PHONE_LOGIN)
    @FormUrlEncoded
//    @Headers({"Content-Type:application/x-www-form-urlencode"})
    Observable<ApiResponse> login(@Field("email") String email,@Field("password") String password);

    @GET(ApiConstants.GET_PRODUCE_PLAN_PROCESS)
    @Headers({"Content-Type:application/x-www-form-urlencode"})
    Observable<ApiResponse<List<SchedulerBean>>> getProducePlanProcess(@Query("planStatus") int planStatus);

    @GET(ApiConstants.GET_DEVICE_INFO_BY_SCAN)
    @Headers({"Content-Type:application/x-www-form-urlencode"})
    Observable<ApiResponse<EquipmentBean>> getDeviceInfoByScan(@Query("barcode") String barcode);

    @GET(ApiConstants.GET_CONFIG_INFO)
//    @Headers({"Content-Type:application/x-www-form-urlencode"})
    Observable<ApiResponse<ConfigBean>> getConfigInfo();

    @POST(ApiConstants.LOGGING_SCHEDULE)
    @Headers({"Content-Type:application/json"})
    Observable<ApiResponse> loggingScheduler(@Body SubmitBean submitBean);

}