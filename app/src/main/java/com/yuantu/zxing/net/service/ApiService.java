package com.yuantu.zxing.net.service;

import com.yuantu.zxing.bean.Product;
import com.yuantu.zxing.net.bean.ApiResponse;
import com.yuantu.zxing.net.bean.ProductBean;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

}
