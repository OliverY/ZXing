package com.yuantu.zxing.ui.latest;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.yuantu.zxing.AppConfig;
import com.yuantu.zxing.BaseActivity;
import com.yuantu.zxing.R;
import com.yuantu.zxing.bean.ConfigBean;
import com.yuantu.zxing.net.ApiFactory;
import com.yuantu.zxing.net.bean.ApiResponse;
import com.yuantu.zxing.ui.old.MainActivity;
import com.yuantu.zxing.utils.ProgressUtils;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Author:  Yxj
 * Time:    2019/5/27 上午9:33
 * -----------------------------------------
 * Description:
 */
public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        findViewById(R.id.btn_old).setOnClickListener(this);
        findViewById(R.id.btn_new).setOnClickListener(this);

        requestPermission();

        getConfig();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_old:
                // 去老的计划
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.btn_new:
                // 去新功能
                startActivity(new Intent(this,Home2Activity.class));
                break;
        }
    }

    private void requestPermission() {
        new RxPermissions(this)
                .request(Manifest.permission.CAMERA)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (!aBoolean) {
                            finish();
                        }
                    }
                });

    }

    public void getConfig() {

        dialog = ProgressUtils.show(this);
        ApiFactory.getConfigInfo()
                .subscribe(new Observer<ConfigBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ConfigBean configBean) {
                        dialog.dismiss();
                        AppConfig.getInstance().setConfigBean(configBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        dialog.dismiss();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
