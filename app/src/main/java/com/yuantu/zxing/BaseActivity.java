package com.yuantu.zxing;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import com.yuantu.zxing.utils.ProgressUtils;

/**
 * Author:  Yxj
 * Time:    2018/7/2 下午10:24
 * -----------------------------------------
 * Description:
 */
public class BaseActivity extends AppCompatActivity {

    private ProgressDialog progress;

    protected void showProgress(){
        dismissProgress();
        progress = ProgressUtils.show(this);
    }

    protected void dismissProgress(){
        if(progress!=null && progress.isShowing()){
            progress.dismiss();
        }
    }
}
