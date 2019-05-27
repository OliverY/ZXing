package com.yuantu.zxing.ui.latest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yuantu.zxing.BaseActivity;
import com.yuantu.zxing.R;
import com.yuantu.zxing.ui.old.MainActivity;

/**
 * Author:  Yxj
 * Time:    2019/5/27 上午9:33
 * -----------------------------------------
 * Description:
 */
public class HomeActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        findViewById(R.id.btn_old).setOnClickListener(this);
        findViewById(R.id.btn_new).setOnClickListener(this);
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
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }
}
