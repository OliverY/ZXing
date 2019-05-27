package com.yuantu.zxing.ui.latest;

import android.app.ProgressDialog;
import android.content.Intent;
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
import com.yuantu.zxing.utils.ProgressUtils;
import com.yuantu.zxing.utils.ToastUtils;

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
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.et_email);
        etPwd = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        etEmail.setText("admin@yuantutech.com");
        etPwd.setText("admin");

        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                String email = etEmail.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();

                progressDialog = ProgressUtils.show(this);

                ApiFactory.login(email,pwd)
                        .subscribe(new Observer<ApiResponse>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(ApiResponse apiResponse) {
                                progressDialog.dismiss();
                                if(apiResponse.isSuccess()){
                                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                                    finish();
                                }else {
                                    ToastUtils.showShort(LoginActivity.this,"登录失败");
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                progressDialog.dismiss();
                                ToastUtils.showShort(LoginActivity.this,"登录失败");
                            }

                            @Override
                            public void onComplete() {

                            }
                        });

                break;
        }
    }
}
