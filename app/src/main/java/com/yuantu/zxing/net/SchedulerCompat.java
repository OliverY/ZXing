package com.yuantu.zxing.net;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Author:  Yxj
 * Time:    2018/7/2 下午3:18
 * -----------------------------------------
 * Description:
 */
public class SchedulerCompat{

    private static final ObservableTransformer newThreadTransfomer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(Observable upstream) {
            return upstream.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        }
    };

    private static final ObservableTransformer ioTransfomer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(Observable upstream) {
            return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
    };

    private static ObservableTransformer computerTransfomer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(Observable upstream) {
            return upstream.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
        }
    };

    public static <T> ObservableTransformer<T,T> newThread(){
        return (ObservableTransformer<T,T>)newThreadTransfomer;
    }

    public static <T> ObservableTransformer<T,T> io(){
        return (ObservableTransformer<T,T>)ioTransfomer;
    }

    public static <T> ObservableTransformer<T,T> computer(){
        return (ObservableTransformer<T,T>)computerTransfomer;
    }
}
