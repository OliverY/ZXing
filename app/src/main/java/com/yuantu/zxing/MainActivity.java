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
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.yuantu.zxing.adapter.ProductAdapter;
import com.yuantu.zxing.bean.Product;
import com.yuantu.zxing.net.ApiFactory;
import com.yuantu.zxing.net.bean.ApiResponse;
import com.yuantu.zxing.net.bean.ProductBean;
import com.yuantu.zxing.net.bean.ProductDetail;
import com.yuantu.zxing.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

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

    private List<ProductBean> total;
    private List<ProductBean> bindedList = new ArrayList<>();
    private List<ProductBean> addList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        product = new Product();

        product.main = "2-136-001-20180702-002";
//        product.main = "1-107-012-20180702-019";
        product.appendix.add("2-136-012-20180702-009");
        product.appendix.add("2-136-012-20180702-010");

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
            if(total.get(position).getType() != 1){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("是否删除该原料")
                        .setPositiveButton("删除", (DialogInterface dialog, int which) -> {
                            // 删除该项

//                            adapter.setNewData(product);
//                            checkBtnEnable();
//                            dialog.dismiss();
                        }).setNegativeButton("取消", (DialogInterface dialog, int which) -> {
                            dialog.dismiss();
                        }).show();
            }
        });
        TextView emptyView = new TextView(this);
        emptyView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        emptyView.setGravity(Gravity.CENTER);
        emptyView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        emptyView.setText("暂未添加原料");
        adapter.bindToRecyclerView(ry);
        adapter.setEmptyView(emptyView);
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
//                getProductInfo("1-107-012-20180702-019");
                getChildDevices(13);

//                new IntentIntegrator(this)
//                        .setOrientationLocked(false)
//                        .setCaptureActivity(ScanActivity.class)
//                        .initiateScan();
                break;
            case R.id.btn_appendix_scan:
                scanIndex = SCAN_APPENDIX;
                new IntentIntegrator(this)
                        .setOrientationLocked(false)
                        .setCaptureActivity(ScanActivity.class)
                        .initiateScan();
                break;
            case R.id.btn_submit:
                for(ProductBean productBean:addList){
                    product.appendix.add(productBean.getBarcode());
                }

                ApiFactory.bind(product)
                        .subscribe(new Observer<ApiResponse>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(ApiResponse apiResponse) {
                                if (apiResponse.isSuccess()) {
                                    ToastUtils.showShort(MainActivity.this, "绑定成功");
                                } else {
                                    ToastUtils.showShort(MainActivity.this, apiResponse.getMsg());
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                ToastUtils.showShort(MainActivity.this, e.getMessage());
                            }

                            @Override
                            public void onComplete() {

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
                ToastUtils.showShort(MainActivity.this, "内容为空");
            } else {
                ToastUtils.showShort(MainActivity.this, "扫描成功");
                // ScanResult 为 获取到的字符串
                String scanResult = intentResult.getContents();

                Log.e("yxj", "扫码成功::" + scanResult);

                if (scanIndex == SCAN_MAIN) {
                    resetData();

                    product.main = scanResult;
                    // 查询网络
                    getProductInfo(scanResult);

                } else if (scanIndex == SCAN_APPENDIX) {
//                    product.appendix.add(scanResult);
//                    adapter.setNewData(product.appendix);

                    scanChildProduct(scanResult);

                    checkBtnEnable();

                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void scanChildProduct(String scanResult) {
        for(ProductBean product:bindedList){
            if(scanResult.equals(product.getBarcode())){
                ToastUtils.showShort(MainActivity.this,"此原料已绑定");
                return;
            }
        }

        for(ProductBean product:addList){
            if(scanResult.equals(product.getBarcode())){
                ToastUtils.showShort(MainActivity.this,"此原料已在待添加列表中");
                return;
            }
        }

        // 查询子条目的信息
        ApiFactory.query(scanResult)
                .subscribe(new Observer<ProductBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductBean productBean) {
                        addList.add(0,productBean);
                        total.clear();
                        total.addAll(addList);
                        total.addAll(bindedList);
                        adapter.setNewData(total);
                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtils.showShort(MainActivity.this, e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void getProductInfo(String scanResult) {

        ApiFactory.query(scanResult)
                .subscribe(new Observer<ProductBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductBean productBean) {
                        tvMain.setText(productBean.toString());
                        product.main = productBean.getBarcode();
                        checkBtnEnable();

                        getChildDevices(productBean.getId());
                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtils.showShort(MainActivity.this, e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    private void getChildDevices(int id) {
        ApiFactory.queryChildDevices(id)
                .subscribe(new Observer<List<ProductBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ProductBean> childDevicesBeans) {
                        for(ProductBean product:childDevicesBeans){
                            product.setType(1);
                        }
                        bindedList = childDevicesBeans;
                        total = bindedList;
                        adapter.setNewData(total);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

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

    private void resetData(){
        total = new ArrayList<>();
        bindedList = new ArrayList<>();
        addList = new ArrayList<>();
        product = new Product();
    }


}
