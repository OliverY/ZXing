package com.yuantu.zxing.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yuantu.zxing.R;

/**
 * Author:  Yxj
 * Time:    2018/7/2 下午9:07
 * -----------------------------------------
 * Description:
 */
public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test);

        setTitle("测试页面");
        findViewById(R.id.btn_ry).setOnClickListener(v->{
            startActivity(new Intent(this,RyActivity.class));
        });
    }
}
