package com.yuantu.zxing;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yuantu.zxing.net.RetrofitClient;

/**
 * Author:  Yxj
 * Time:    2018/7/3 上午9:37
 * -----------------------------------------
 * Description:
 */
public class SwitchActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("测试页");

        setContentView(R.layout.activity_switch);
        findViewById(R.id.btn_8080).setOnClickListener(v->{
            RetrofitClient.BASE_URL = "http://120.55.185.136:8080/jszx/";
            startActivity(new Intent(SwitchActivity.this,MainActivity.class));
        });

        findViewById(R.id.btn_8090).setOnClickListener(v->{
            RetrofitClient.BASE_URL = "http://120.55.185.136:8090/jszx/";
            startActivity(new Intent(SwitchActivity.this,MainActivity.class));
        });

    }
}
