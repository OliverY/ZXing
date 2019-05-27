package com.yuantu.zxing.ui.latest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.yuantu.zxing.BaseActivity;
import com.yuantu.zxing.Constants;
import com.yuantu.zxing.R;
import com.yuantu.zxing.adapter.CheckVPAdatper;

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

        List<String> titles = new ArrayList<>();
        titles.add("进行中");
        titles.add("已完成");

        List<Fragment> fragmentList = new ArrayList<>();


        Bundle bundle1 = new Bundle();
        bundle1.putInt(Constants.ActivityExtra.PLAN_STATUS,1);
        CheckFragment checkFragment1 = new CheckFragment();
        checkFragment1.setArguments(bundle1);
        fragmentList.add(checkFragment1);

        Bundle bundle2 = new Bundle();
        bundle2.putInt(Constants.ActivityExtra.PLAN_STATUS,2);
        CheckFragment checkFragment2 = new CheckFragment();
        checkFragment2.setArguments(bundle2);
        fragmentList.add(checkFragment2);

        CheckVPAdatper adatper = new CheckVPAdatper(titles,fragmentList,getSupportFragmentManager());
        viewPager.setAdapter(adatper);

        tabLayout.setupWithViewPager(viewPager);
    }
}
