package com.yuantu.zxing.net.service;

import com.yuantu.zxing.net.bean.ApiResponse;
import com.yuantu.zxing.net.bean.ProductBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Author:  Yxj
 * Time:    2018/7/2 上午11:33
 * -----------------------------------------
 * Description:
 */
public interface ApiService {

    @GET("product/query")
    Call<ApiResponse<ProductBean>> query(@Query("barcode") String barCode);


}
