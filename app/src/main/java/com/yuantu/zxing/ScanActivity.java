package com.yuantu.zxing;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

/**
 * Author:  Yxj
 * Time:    2018/6/27 下午1:52
 * -----------------------------------------
 * Description:
 */
public class ScanActivity extends AppCompatActivity {

    CaptureManager captureManager;
    private DecoratedBarcodeView mDBV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getIntent().getBooleanExtra(Constants.ActivityExtra.IS_QR,true)){
            setContentView(R.layout.activity_scan_qr);
        }else{
            setContentView(R.layout.activity_scan);
        }

        mDBV = findViewById(R.id.dbv);

        captureManager = new CaptureManager(this,mDBV);
        captureManager.initializeFromIntent(getIntent(),savedInstanceState);
        captureManager.decode();

        mDBV.setStatusText("请把二维码至于扫描框内");

    }

    @Override
    protected void onPause() {
        super.onPause();
        captureManager.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        captureManager.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        captureManager.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        captureManager.onSaveInstanceState(outState);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return mDBV.onKeyDown(keyCode,event)||super.onKeyDown(keyCode,event);
    }


}
