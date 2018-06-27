package com.yuantu.zxing;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.Map;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvResult;
    private MapData data;
    private Button btnScan;
    private Button btnReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScan = findViewById(R.id.btn_scan);
        btnReset = findViewById(R.id.btn_reset);
        btnScan.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        findViewById(R.id.btn_scan).setOnClickListener(this);
        tvResult = findViewById(R.id.tv_result);

        data = new MapData();

        requestPermission();
    }

    private void requestPermission() {
        new RxPermissions(this)
                .request(Manifest.permission.CAMERA)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if(!aBoolean){
                            finish();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_scan:
                new IntentIntegrator(this)
                        .setOrientationLocked(false)
                        .setCaptureActivity(ScanActivity.class)
                        .initiateScan();
                break;
            case R.id.btn_reset:
                data = new MapData();
                btnScan.setEnabled(true);
                tvResult.setText("重置");
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(intentResult != null) {
            if(intentResult.getContents() == null) {
                Toast.makeText(this,"内容为空",Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this,"扫描成功",Toast.LENGTH_LONG).show();
                // ScanResult 为 获取到的字符串
                String ScanResult = intentResult.getContents();

                setData(ScanResult);


            }
        } else {
            super.onActivityResult(requestCode,resultCode,data);
        }
    }

    private void setData(String scanResult){
        if(TextUtils.isEmpty(data.key)){
            data.key = scanResult;

            new IntentIntegrator(this)
                    .setOrientationLocked(false)
                    .setCaptureActivity(ScanActivity.class)
                    .initiateScan();

        }else{
            data.value = scanResult;
            btnScan.setEnabled(false);
        }
        tvResult.setText("key:"+data.key+"\r\n value:"+data.value);
    }

}
