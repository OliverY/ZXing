package com.yuantu.zxing.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.yuantu.zxing.bean.ConfigBean;

import java.util.List;

/**
 * Author:  Yxj
 * Time:    2019/5/27 上午10:21
 * -----------------------------------------
 * Description:
 */
public class CheckVPAdatper extends FragmentPagerAdapter {

    List<ConfigBean.Config> configList;
    List<Fragment> fragmentList;

    public CheckVPAdatper(List<ConfigBean.Config> configList, List<Fragment> fragmentList, FragmentManager fm) {
        super(fm);
        this.configList = configList;
        this.fragmentList = fragmentList;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return view == object;
//    }

    @Override
    public CharSequence getPageTitle(int position) {
        return configList.get(position).getDescribe();
    }
}
