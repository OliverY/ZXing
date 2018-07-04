package com.yuantu.zxing.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.yuantu.zxing.R;

/**
 * Author:  Yxj
 * Time:    2018/7/4 下午8:52
 * -----------------------------------------
 * Description:
 */
public class ProgressUtils {

    public static ProgressDialog show(Context context){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if(progressDialog!=null){
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.dialog_progress);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }
}
