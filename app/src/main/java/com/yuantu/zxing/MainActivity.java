package com.yuantu.zxing;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.yuantu.zxing.adapter.MyAdapter;

import java.util.ArrayList;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvMain;
    private RecyclerView ry;
    private Product product;
    private Button btnMainScan;
    private Button btnAppendixScan;
    private Button btnSubmit;
    private MyAdapter adapter;

    // 代表扫码的入口
    private static final int SCAN_MAIN = 1;
    private static final int SCAN_APPENDIX = 2;

    private int scanIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        product = new Product();

        initview();
        requestPermission();
    }

    private void initview() {
        btnMainScan = findViewById(R.id.btn_main_scan);
        btnAppendixScan = findViewById(R.id.btn_appendix_scan);
        btnSubmit = findViewById(R.id.btn_submit);
        btnMainScan.setOnClickListener(this);
        btnAppendixScan.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);

        tvMain = findViewById(R.id.tv_main);
        ry = findViewById(R.id.ry);

        ry.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new MyAdapter();
        adapter.setOnItemClickListener((BaseQuickAdapter adapter, View view, int position) -> {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("是否删除该原料")
                    .setPositiveButton("删除", (DialogInterface dialog, int which) -> {
                        product.appendix.remove(position);
                        adapter.setNewData(product.appendix);
                        checkBtnEnable();
                        dialog.dismiss();
                    }).setNegativeButton("取消", (DialogInterface dialog, int which) -> {
                dialog.dismiss();
            }).show();
        });
        ry.setAdapter(adapter);

        btnAppendixScan.setEnabled(false);
        btnSubmit.setEnabled(false);

        checkBtnEnable();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_scan:
                scanIndex = SCAN_MAIN;
                new IntentIntegrator(this)
                        .setOrientationLocked(false)
                        .setCaptureActivity(ScanActivity.class)
                        .initiateScan();
                break;
            case R.id.btn_appendix_scan:
                scanIndex = SCAN_APPENDIX;
                new IntentIntegrator(this)
                        .setOrientationLocked(false)
                        .setCaptureActivity(ScanActivity.class)
                        .initiateScan();
                break;
            case R.id.btn_submit:
                // map提交

                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(this, "内容为空", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "扫描成功", Toast.LENGTH_LONG).show();
                // ScanResult 为 获取到的字符串
                String scanResult = intentResult.getContents();

                if (scanIndex == SCAN_MAIN) {
                    product.main = scanResult;
                    product.appendix = new ArrayList<>();
                } else if (scanIndex == SCAN_APPENDIX) {
                    product.appendix.add(scanResult);
                    adapter.setNewData(product.appendix);
                }
                checkBtnEnable();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void checkBtnEnable() {
        checkAppendixScanEnable();
        checkSubmitEnable();
    }

    private void checkAppendixScanEnable() {
        btnAppendixScan.setEnabled(TextUtils.isEmpty(product.main));
    }

    private void checkSubmitEnable() {
        btnSubmit.setEnabled(product.appendix.size() > 0);
    }

}
