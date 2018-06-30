package com.yuantu.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(v -> {
            OKHttpUtils.getInstance().login(new ObjCallback<LoginBean>(){
                @Override
                public Class<LoginBean> getClazz() {
                    return LoginBean.class;
                }

                @Override
                public Listener<LoginBean> getListener() {
                    return new Listener<LoginBean>() {
                        @Override
                        public void onSuccess(LoginBean loginBean) {
                            Log.i("yxj","response::"+loginBean.toString());
//                            tvResult.setText();
                        }

                        @Override
                        public void onFailed(String msg) {
                            Log.i("yxj","error::"+msg);
//                            tvResult.setText(msg);
                        }
                    };
                }
            } );

            tvResult = findViewById(R.id.tv_result);

        });
    }
}