package com.yuantu.zxing.ui.old;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuantu.zxing.BaseActivity;
import com.yuantu.zxing.Constants;
import com.yuantu.zxing.R;
import com.yuantu.zxing.adapter.ProductBindedAdapter;
import com.yuantu.zxing.net.ApiFactory;
import com.yuantu.zxing.net.bean.ProductBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Author:  Yxj
 * Time:    2018/7/3 下午4:16
 * -----------------------------------------
 * Description:
 */
public class BindedActivity extends BaseActivity {

    private RecyclerView ry;
    private ProductBindedAdapter bindedAdapter;
    private int id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        id = getIntent().getIntExtra(Constants.ActivityExtra.ID,-1);
        setContentView(R.layout.activity_binded);

        initView();
        initData();
    }

    private void initData() {
        if(id!=-1){
            getChildDevices(id);
        }
    }

    private void initView() {
        ry = findViewById(R.id.ry);
        initRyBinded();
    }

    private void initRyBinded() {

        ry.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        bindedAdapter = new ProductBindedAdapter();

        TextView emptyView = new TextView(this);
        emptyView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        emptyView.setGravity(Gravity.CENTER);
        emptyView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        emptyView.setText("暂无绑定原料");
        bindedAdapter.bindToRecyclerView(ry);
        bindedAdapter.setEmptyView(emptyView);
        ry.setAdapter(bindedAdapter);
    }

    private void getChildDevices(int id) {
        showProgress();

        ApiFactory.queryChildDevices(id)
                .subscribe(new Observer<List<ProductBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ProductBean> childDevicesBeans) {
                        dismissProgress();
                        bindedAdapter.setNewData(childDevicesBeans);
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
}
