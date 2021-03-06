package com.yuantu.zxing.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuantu.zxing.R;

/**
 * Author:  Yxj
 * Time:    2018/6/28 上午11:35
 * -----------------------------------------
 * Description:
 */
public class ProductAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public ProductAdapter() {
        super(R.layout.item_appendix);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv,item);
        helper.getView(R.id.tv).setBackground(mContext.getResources().getDrawable(helper.getLayoutPosition()%2==0?R.drawable.bg_item_even:R.drawable.bg_item_odd));
    }
}
