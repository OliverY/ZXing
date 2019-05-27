package com.yuantu.zxing.ui.latest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yuantu.zxing.BaseActivity;
import com.yuantu.zxing.R;
import com.yuantu.zxing.common.widget.CircleProgressIndicator;
import com.yuantu.zxing.common.widget.LinearProgressIndicator;
import com.yuantu.zxing.net.ApiFactory;
import com.yuantu.zxing.net.bean.ApiResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Author:  Yxj
 * Time:    2019/5/27 上午8:55
 * -----------------------------------------
 * Description:
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText etEmail;
    private EditText etPwd;
    private Button btnLogin;
    private CircleProgressIndicator circleProgressIndicator;
    private LinearProgressIndicator linearProgressIndicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.et_email);
        etPwd = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        circleProgressIndicator = findViewById(R.id.circle_indicator);
        linearProgressIndicator = findViewById(R.id.linear_indicator);



        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
//                String email = etEmail.getText().toString().trim();
//                String pwd = etPwd.getText().toString().trim();
//
//                ApiFactory.login(email,pwd)
//                        .subscribe(new Observer<ApiResponse>() {
//                            @Override
//                            public void onSubscribe(Disposable d) {
//
//                            }
//
//                            @Override
//                            public void onNext(ApiResponse apiResponse) {
//
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//
//                            }
//
//                            @Override
//                            public void onComplete() {
//
//                            }
//                        });

//                circleProgressIndicator.setData(150,30,R.color.color_6D81FD,"设备总数");

                linearProgressIndicator.setIndex(9);

                break;
        }
    }
}
