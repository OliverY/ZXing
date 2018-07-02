package com.yuantu.zxing.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuantu.zxing.R;
import com.yuantu.zxing.net.bean.ProductBean;

/**
 * Author:  Yxj
 * Time:    2018/6/28 上午11:35
 * -----------------------------------------
 * Description:
 */
public class ProductBindedAdapter extends BaseQuickAdapter<ProductBean,BaseViewHolder> {

    public ProductBindedAdapter() {
        super(R.layout.item_appendix);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductBean item) {
        helper.setText(R.id.tv_detail,item.toString());
        helper.getView(R.id.tv_type).setVisibility(View.GONE);
        helper.getView(R.id.layout).setBackground(mContext.getResources().getDrawable(helper.getLayoutPosition()%2==0?R.drawable.bg_item_even:R.drawable.bg_item_odd));
    }
}
