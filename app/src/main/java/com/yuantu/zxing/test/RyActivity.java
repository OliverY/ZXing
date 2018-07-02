package com.yuantu.zxing.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuantu.zxing.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:  Yxj
 * Time:    2018/7/2 下午9:09
 * -----------------------------------------
 * Description:
 */
public class RyActivity extends AppCompatActivity {

    private RecyclerView ry;
    private BaseQuickAdapter adapter;
    private List<String> total;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ry);

        setTitle("测试页面");
        findViewById(R.id.btn_add).setOnClickListener(v -> {

            total.add(0, "增加一个 head");
            adapter.notifyItemInserted(0);

        });
        findViewById(R.id.btn_delete).setOnClickListener(v -> {

        });
        ry = findViewById(R.id.ry);


        initData();

    }

    private void initData() {
        total = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            total.add("This is num: " + i + " index");
        }

        adapter = new BaseQuickAdapter<String, BaseViewHolder>(android.R.layout.simple_list_item_1) {

            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(android.R.id.text1, item);
            }
        };

        adapter.setOnItemLongClickListener((BaseQuickAdapter adapter, View view, int position) -> {
            total.remove(position);
            adapter.notifyItemRemoved(position);
            return true;
        });

        ry.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ry.setAdapter(adapter);

        adapter.setNewData(total);
    }
}
