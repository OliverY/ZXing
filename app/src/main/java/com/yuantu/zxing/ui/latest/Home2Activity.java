package com.yuantu.zxing.ui.latest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yuantu.zxing.BaseActivity;
import com.yuantu.zxing.R;

/**
 * Author:  Yxj
 * Time:    2019/5/27 上午9:42
 * -----------------------------------------
 * Description:
 */
public class Home2Activity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home_2);

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
                break;
            case R.id.btn_check:
                /*
                直接跳转到 查询页面
                 */
                break;
        }
    }
}
