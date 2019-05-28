package com.yuantu.zxing.ui.latest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.yuantu.zxing.config.AppConfig;
import com.yuantu.zxing.BaseActivity;
import com.yuantu.zxing.Constants;
import com.yuantu.zxing.R;
import com.yuantu.zxing.adapter.CheckVPAdatper;
import com.yuantu.zxing.bean.ConfigBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:  Yxj
 * Time:    2019/5/27 上午10:15
 * -----------------------------------------
 * Description:
 */
public class CheckActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_check);

        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.view_pager);

        init();

    }

    private void init() {

//        List<String> titles = new ArrayList<>();
//        titles.add("进行中");
//        titles.add("已完成");
//        titles.add("已取消");

        List<ConfigBean.Config> configList = AppConfig.getInstance().getConfigBean().getTypeId_121();
        List<Fragment> fragmentList = new ArrayList<>();

        for (int i = 0; i < configList.size(); i++) {
            Bundle bundle = new Bundle();
            bundle.putInt(Constants.ActivityExtra.PLAN_STATUS,configList.get(i).getId());
            CheckFragment checkFragment1 = new CheckFragment();
            checkFragment1.setArguments(bundle);
            fragmentList.add(checkFragment1);
        }

        CheckVPAdatper adatper = new CheckVPAdatper(configList,fragmentList,getSupportFragmentManager());
        viewPager.setAdapter(adatper);

        tabLayout.setupWithViewPager(viewPager);
    }
}
