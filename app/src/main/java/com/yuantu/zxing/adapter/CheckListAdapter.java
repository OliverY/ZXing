package com.yuantu.zxing.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuantu.zxing.R;
import com.yuantu.zxing.bean.SchedulerBean;

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
    protected void convert(BaseViewHolder baseViewHolder, SchedulerBean checkProductBean) {

    }
}
