package com.yuantu.zxing.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuantu.zxing.R;
import com.yuantu.zxing.bean.SchedulerBean;
import com.yuantu.zxing.common.widget.CircleProgressIndicator;
import com.yuantu.zxing.common.widget.LinearProgressIndicator;

/**
 * Author:  Yxj
 * Time:    2019/5/27 上午11:48
 * -----------------------------------------
 * Description:
 */
public class CheckListAdapter extends BaseQuickAdapter<SchedulerBean,BaseViewHolder> {

    public CheckListAdapter() {
        super(R.layout.item_check);
    }

    @Override
    protected void convert(BaseViewHolder helper, SchedulerBean item) {
        helper.setText(R.id.tv_hospital,item.getProjectName());
        helper.setText(R.id.tv_equipment,item.getDeviceTypeDesc());
        helper.setText(R.id.tv_time,item.getStartTime());

        CircleProgressIndicator indicator1 = helper.getView(R.id.circle_indicator_1);
        CircleProgressIndicator indicator2 = helper.getView(R.id.circle_indicator_2);
        CircleProgressIndicator indicator3 = helper.getView(R.id.circle_indicator_3);
        CircleProgressIndicator indicator4 = helper.getView(R.id.circle_indicator_4);

        indicator1.setData(item.getDeviceNumber(),item.getDeviceNumber(),R.color.color_429FFF,"设备总数");
        indicator2.setData(item.getDeviceNumber(),item.getModuleInstalled(),R.color.color_6D81FD,"模块安装");
        indicator3.setData(item.getDeviceNumber(),item.getDeviceWired(),R.color.color_A68FFE,"设备布线");
        indicator4.setData(item.getDeviceNumber(),item.getDeviceTested(),R.color.color_E78FFE,"设备测试");

        LinearProgressIndicator linearIndicator = helper.getView(R.id.linea_indricator);
        linearIndicator.setIndex(Integer.parseInt(item.getRate().replace("%","")));
    }
}
