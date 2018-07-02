package com.yuantu.zxing.adapter;

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
public class ProductAdapter extends BaseQuickAdapter<ProductBean,BaseViewHolder> {

    public ProductAdapter() {
        super(R.layout.item_appendix);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductBean item) {
        helper.setText(R.id.tv_detail,item.toString());
        helper.setText(R.id.tv_type,item.getType()==1?"已绑定":"未绑定");
        if(item.getType() == 1){
            helper.getView(R.id.layout).setBackgroundColor(mContext.getResources().getColor(R.color.color_99CC00));
        }else{
            helper.getView(R.id.layout).setBackground(mContext.getResources().getDrawable(helper.getLayoutPosition()%2==0?R.drawable.bg_item_even:R.drawable.bg_item_odd));
        }
    }
}
