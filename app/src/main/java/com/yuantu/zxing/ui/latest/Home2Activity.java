package com.yuantu.zxing.ui.latest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.yuantu.zxing.BaseActivity;
import com.yuantu.zxing.Constants;
import com.yuantu.zxing.R;
import com.yuantu.zxing.bean.EquipmentBean;
import com.yuantu.zxing.net.ApiFactory;
import com.yuantu.zxing.ui.old.MainActivity;
import com.yuantu.zxing.ui.old.ScanActivity;
import com.yuantu.zxing.utils.ProgressUtils;
import com.yuantu.zxing.utils.RegExUtils;
import com.yuantu.zxing.utils.ToastUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Author:  Yxj
 * Time:    2019/5/27 上午9:42
 * -----------------------------------------
 * Description:
 */
public class Home2Activity extends BaseActivity implements View.OnClickListener {

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home_2);

        setTitle("新功能主页");

        findViewById(R.id.btn_logging).setOnClickListener(this);
        findViewById(R.id.btn_check).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_logging:
                /*
                 1.跳二维码扫描
                 2.扫描到二维码跳转到查询接口
                 3.跳转到新页面
                  */
                new IntentIntegrator(this)
                        .addExtra(Constants.ActivityExtra.IS_QR,true)
                        .setOrientationLocked(false)
                        .setCaptureActivity(ScanActivity.class)
                        .initiateScan();

                break;
            case R.id.btn_check:
                /*
                直接跳转到 查询页面
                 */
                Intent intent = new Intent(this,CheckActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                ToastUtils.showShort(Home2Activity.this, "内容为空");
            } else {
                // ScanResult 为 获取到的字符串
                String scanResult = intentResult.getContents();

                getDeviceResult(scanResult);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void getDeviceResult(String barcode){
        progressDialog = ProgressUtils.show(this);

        ApiFactory.getDeviceInfoByScan(barcode)
                .subscribe(new Observer<EquipmentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(EquipmentBean equipmentBean) {
                        progressDialog.dismiss();
                        Intent intent = new Intent(Home2Activity.this,LoggingActivity.class);
                        intent.putExtra(Constants.ActivityExtra.EQUIPMENT,equipmentBean);
                        startActivity(intent);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
