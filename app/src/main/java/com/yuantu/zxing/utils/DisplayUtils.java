package com.yuantu.zxing.utils;

import android.content.Context;
import android.view.WindowManager;

/**
 * Author:  Yxj
 * Time:    2018/6/29 下午9:09
 * -----------------------------------------
 * Description:
 */
public class DisplayUtils {

    public static int dp2px(Context context,int dp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dp*density+0.5f);
    }

    public static int px2dp(Context context,int px){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (px/density+0.5f);
    }
}
