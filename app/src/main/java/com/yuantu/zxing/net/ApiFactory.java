package com.yuantu.zxing.net;

import com.yuantu.zxing.bean.Product;
import com.yuantu.zxing.bean.SchedulerBean;
import com.yuantu.zxing.net.bean.ApiResponse;
import com.yuantu.zxing.net.bean.ProductBean;
import com.yuantu.zxing.net.bean.ProductDetail;
import com.yuantu.zxing.net.service.ApiService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

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

    public static Observable<List<ProductBean>> queryChildDevices(int id){
        return getApiService().queryChildDevices(id).map(new HttpResultFunc<>()).map(new Function<ProductDetail, List<ProductBean>>() {
            @Override
            public List<ProductBean> apply(ProductDetail productDetail) throws Exception {
                return productDetail.getChildDevices();
            }
        }).compose(SchedulerCompat.newThread());
    }

    public static Observable<ProductBean> queryMaterial(String barCode) {
        return getApiService().queryMaterial(barCode).map(new HttpResultFunc<ProductBean>()).compose(SchedulerCompat.newThread());
    }

    public static Observable<ApiResponse> login(String email,String password) {
        return getApiService().login(email,password).compose(SchedulerCompat.newThread());
    }

    public static Observable<List<SchedulerBean>> getProducePlanProcess(int planStatus) {
        return getApiService().getProducePlanProcess(planStatus).map(new HttpResultFunc<List<SchedulerBean>>()).compose(SchedulerCompat.newThread());
    }

}