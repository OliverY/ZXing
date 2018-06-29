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

        findViewById(R.id.btn).setOnClickListener(v->{
            OKHttpUtils.getInstance().login(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("yxj",e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String result = new String(response.body().bytes());
                    Log.e("yxj",result);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvResult.setText(result);
                        }
                    });
                }
            });
        });

        tvResult = findViewById(R.id.tv_result);

    }
}
