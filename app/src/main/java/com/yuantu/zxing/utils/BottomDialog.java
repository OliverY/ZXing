package com.yuantu.zxing.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.yuantu.zxing.R;

/**
 * Author:  Yxj
 * Time:    2019/5/27 下午3:07
 * -----------------------------------------
 * Description:
 */
public class BottomDialog extends Dialog {

    View view;

    public BottomDialog(@NonNull Context context, View view) {
        super(context, R.style.BottomDialogStyle);
        this.view = view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(view);//这行一定要写在前面
        setCancelable(false);//点击外部不可dismiss
        setCanceledOnTouchOutside(false);
        Window window = this.getWindow();
        window.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
//        params.width = DisplayUtils.getScreenWidth(getContext());
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(params);
    }
}
