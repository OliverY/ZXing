package com.yuantu.zxing.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Author:  Yxj
 * Time:    2018/6/28 下午2:13
 * -----------------------------------------
 * Description:
 */
public class ToastUtils {

    public static void showShort(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
