package com.yuantu.zxing.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:  Yxj
 * Time:    2018/6/27 下午2:36
 * -----------------------------------------
 * Description:
 */
public class Product {

    public String main;
    public List<String> appendix = new ArrayList<>();

    public Product() {
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public List<String> getAppendix() {
        return appendix;
    }

    public void setAppendix(List<String> appendix) {
        this.appendix = appendix;
    }
}
