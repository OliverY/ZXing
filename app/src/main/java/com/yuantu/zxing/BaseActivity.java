package com.yuantu.zxing;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Author:  Yxj
 * Time:    2018/7/2 下午10:24
 * -----------------------------------------
 * Description:
 */
public class BaseActivity extends AppCompatActivity {


    private ProgressDialog progress;

    protected void showProgress(){
        if(progress == null){
            progress = new ProgressDialog(this);
            progress.setMessage("数据加载中...");
        }
        progress.show();
    }

    protected void dismissProgress(){
        if(progress!=null && progress.isShowing()){
            progress.dismiss();
        }
    }
}
