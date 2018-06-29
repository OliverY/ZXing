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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.yuantu.zxing.adapter.ProductAdapter;
import com.yuantu.zxing.bean.Product;
import com.yuantu.zxing.net.Api;
import com.yuantu.zxing.net.bean.ProductBean;
import com.yuantu.zxing.utils.ToastUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.functions.Consumer;
import okhttp3.Call;

/**
 * 记得改写成clean mvp
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvMain;
    private RecyclerView ry;
    private Product product;
    private Button btnMainScan;
    private Button btnAppendixScan;
    private Button btnSubmit;
    private ProductAdapter adapter;

    // 代表扫码的入口
    private static final int SCAN_MAIN = 1;
    private static final int SCAN_APPENDIX = 2;

    private int scanIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        product = new Product();

        product.main = "1-06b-003-20180629-055";
        /*
        1-06b-003-20180629-056
        1-06b-003-20180629-057
         */
        product.appendix.add("1-06b-003-20180629-056");
        product.appendix.add("1-06b-003-20180629-057");

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
        adapter = new ProductAdapter();
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
//                getProductInfo("1-06b-003-20180629-055");

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
                Api.bind(product, new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtils.showShort(MainActivity.this, e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            JSONObject responseJson = new JSONObject(response);
                            boolean isSuccess = responseJson.getBoolean("success");
                            if (isSuccess) {
                                ToastUtils.showShort(MainActivity.this, "绑定成功");
                            } else {
                                ToastUtils.showShort(MainActivity.this, responseJson.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            ToastUtils.showShort(MainActivity.this, e.getMessage());
                        }
                    }
                });

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

                Log.e("yxj", "扫码成功::" + scanResult);

                if (scanIndex == SCAN_MAIN) {
                    product.main = scanResult;
                    product.appendix = new ArrayList<>();
                    // 查询网络
                    getProductInfo(scanResult);

                } else if (scanIndex == SCAN_APPENDIX) {
                    product.appendix.add(scanResult);
                    adapter.setNewData(product.appendix);
                    checkBtnEnable();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void getProductInfo(String scanResult) {

        Api.query(scanResult, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                ToastUtils.showShort(MainActivity.this, e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                try {
                    JSONObject responseJson = new JSONObject(response);
                    boolean isSuccess = responseJson.getBoolean("success");
                    if (isSuccess) {
                        String objStr = responseJson.getString("data");
                        Gson gson = new Gson();
                        ProductBean productBean = gson.fromJson(objStr, ProductBean.class);
                        tvMain.setText(productBean.toString());

                        product.main = productBean.getBarcode();
                        checkBtnEnable();
                    } else {
                        ToastUtils.showShort(MainActivity.this, responseJson.getString("msg"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    ToastUtils.showShort(MainActivity.this, e.getMessage());
                }
            }
        });
    }

    private void checkBtnEnable() {
        checkAppendixScanEnable();
        checkSubmitEnable();
    }

    private void checkAppendixScanEnable() {
        btnAppendixScan.setEnabled(!TextUtils.isEmpty(product.main));
    }

    private void checkSubmitEnable() {
        btnSubmit.setEnabled(product.appendix.size() > 0);
    }


}
