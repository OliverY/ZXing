package com.yuantu.zxing.net;

import com.yuantu.zxing.bean.Product;
import com.yuantu.zxing.net.bean.ApiResponse;
import com.yuantu.zxing.net.bean.ProductBean;
import com.yuantu.zxing.net.service.ApiService;

import io.reactivex.Observable;

/**
 * Author:  Yxj
 * Time:    2018/7/2 上午11:38
 * -----------------------------------------
 * Description:
 */
public class ApiFactory {

    private static ApiService getApiService() {
        return RetrofitClient.getInstance().getRetrofit().create(ApiService.class);
    }

    public static Observable<ProductBean> query(String barCode) {
        return getApiService().query(barCode).map(new HttpResultFunc<ProductBean>()).compose(SchedulerCompat.newThread());
    }

    public static Observable<ApiResponse> bind(Product product){
        return getApiService().bind(product).compose(SchedulerCompat.newThread());
    }
}