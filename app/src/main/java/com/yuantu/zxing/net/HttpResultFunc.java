package com.yuantu.zxing.net;

import com.yuantu.zxing.net.bean.ApiResponse;

import io.reactivex.functions.Function;

/**
 * Author:  Yxj
 * Time:    2018/7/2 下午3:06
 * -----------------------------------------
 * Description:
 */
public class HttpResultFunc<T> implements Function<ApiResponse<T>, T> {
    @Override
    public T apply(ApiResponse<T> apiResponse) throws Exception {
        if(!apiResponse.isSuccess()){
            throw new ApiException(apiResponse.getMsg());
        }
        return apiResponse.getData();
    }
}
