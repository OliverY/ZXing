package com.yuantu.zxing;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import com.yuantu.zxing.adapter.ProductBindedAdapter;
import com.yuantu.zxing.bean.Product;
import com.yuantu.zxing.net.ApiFactory;
import com.yuantu.zxing.net.bean.ApiResponse;
import com.yuantu.zxing.net.bean.ProductBean;
import com.yuantu.zxing.utils.RegExUtils;
import com.yuantu.zxing.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * 记得改写成clean mvp
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvMain;
    private RecyclerView ryAdd;
    private RecyclerView ryBinded;
    private Product product;
    private Button btnMainScan;
    private Button btnAppendixScan;
    private Button btnSubmit;
    private ProductAdapter addAdapter;
    private ProductBindedAdapter bindedAdapter;

    // 代表扫码的入口
    private static final int SCAN_MAIN = 1;
    private static final int SCAN_APPENDIX = 2;

    private int scanIndex;

    private List<ProductBean> addedList = new ArrayList<>();
    private List<ProductBean> bindedList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        product = new Product();

//        product.main = "2-136-001-20180702-002";
//        product.main = "1-107-012-20180702-019";
//        product.appendix.add("2-136-012-20180702-009");
//        product.appendix.add("2-136-012-20180702-010");

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
        ryAdd = findViewById(R.id.ry_add);
        ryBinded = findViewById(R.id.ry_binded);

        initRyBinded();
        initRyAdd();

        btnAppendixScan.setEnabled(false);
        btnSubmit.setEnabled(false);

        checkBtnEnable();
    }

    private void initRyAdd() {

        ryAdd.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        addAdapter = new ProductAdapter();
        addAdapter.setOnItemClickListener((BaseQuickAdapter adapter, View view, int position) -> {
            if (addedList.get(position).getType() != 1) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("是否删除该原料")
                        .setPositiveButton("删除", (DialogInterface dialog, int which) -> {
                            // 删除该项

                            addedList.remove(position);
                            addAdapter.notifyItemRemoved(position);

                            checkBtnEnable();
                            dialog.dismiss();
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
        addAdapter.bindToRecyclerView(ryAdd);
        addAdapter.setEmptyView(emptyView);
        ryAdd.setAdapter(addAdapter);
        addAdapter.setNewData(addedList);
    }

    private void initRyBinded() {

        ryBinded.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        bindedAdapter = new ProductBindedAdapter();

        TextView emptyView = new TextView(this);
        emptyView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        emptyView.setGravity(Gravity.CENTER);
        emptyView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        emptyView.setText("暂无绑定原料");
        bindedAdapter.bindToRecyclerView(ryAdd);
        bindedAdapter.setEmptyView(emptyView);
        ryBinded.setAdapter(bindedAdapter);
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
//                getChildDevices(13);
//                startActivity(new Intent(this, TestActivity.class));

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
                for (ProductBean productBean : addedList) {
                    product.appendix.add(productBean.getBarcode());
                }

                showProgress();
                ApiFactory.bind(product)
                        .subscribe(new Observer<ApiResponse>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(ApiResponse apiResponse) {
                                dismissProgress();
                                if (apiResponse.isSuccess()) {
                                    ToastUtils.showShort(MainActivity.this, "绑定成功");
                                } else {
                                    ToastUtils.showShort(MainActivity.this, apiResponse.getMsg());
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                dismissProgress();
                                ToastUtils.showShort(MainActivity.this, e.getMessage());
                            }

                            @Override
                            public void onComplete() {
                                // 绑定成功后刷新绑定的子元素列表
                                getProductInfo(product.main);
                                addedList.clear();
                                addAdapter.notifyDataSetChanged();

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
                // ScanResult 为 获取到的字符串
                String scanResult = intentResult.getContents();

                int resultType = RegExUtils.checkCode(scanResult);

                if (resultType == Constants.MaterialType.TYPE_NONE) {
                    ToastUtils.showShort(MainActivity.this, "扫码不准确，请重新扫码");
                    return;
                }

                Log.e("yxj", "扫码成功::" + scanResult);

                if (scanIndex == SCAN_MAIN) {
                    if (resultType != Constants.MaterialType.TYPE_PRODUCT) {
                        ToastUtils.showShort(MainActivity.this, "该产品不是成品，请重新扫码");
                        return;
                    }

                    resetData();
                    resetUI();
                    product.main = scanResult;
                    // 查询网络
                    getProductInfo(scanResult);
                } else if (scanIndex == SCAN_APPENDIX) {
                    if (resultType != Constants.MaterialType.TYPE_CHILD) {
                        ToastUtils.showShort(MainActivity.this, "该产品不是原料，请重新扫码");
                        return;
                    }

                    scanChildProduct(scanResult);
                    checkBtnEnable();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void scanChildProduct(String scanResult) {
        // 检查重复
        for (ProductBean product : addedList) {
            if (scanResult.equals(product.getBarcode())) {
                ToastUtils.showShort(MainActivity.this, "此原料已在待添加列表中");
                return;
            }
        }

        for (ProductBean product : bindedList) {
            if (scanResult.equals(product.getBarcode())) {
                ToastUtils.showShort(MainActivity.this, "此原料已绑定");
                return;
            }
        }

        showProgress();

        // 查询子条目的信息
        ApiFactory.queryMaterial(scanResult)
                .subscribe(new Observer<ProductBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductBean productBean) {
                        dismissProgress();
                        addedList.add(0, productBean);
                        addAdapter.setNewData(addedList);

                        checkBtnEnable();
                    }

                    @Override
                    public void onError(Throwable e) {
                        dismissProgress();
                        ToastUtils.showShort(MainActivity.this, e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void getProductInfo(String scanResult) {

        showProgress();

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
                        dismissProgress();
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
                        dismissProgress();
                        for (ProductBean product : childDevicesBeans) {
                            product.setType(1);
                        }
                        bindedList = childDevicesBeans;
                        bindedAdapter.setNewData(bindedList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        dismissProgress();
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
        if (addedList != null) {
            for (ProductBean productBean : addedList) {
                btnSubmit.setEnabled(true);
                return;
            }
        }
        btnSubmit.setEnabled(false);

    }

    private void resetData() {
        bindedList = new ArrayList<>();
        addedList = new ArrayList<>();
        product = new Product();
    }

    private void resetUI() {
        addAdapter.notifyDataSetChanged();
        bindedAdapter.notifyDataSetChanged();
    }


}
