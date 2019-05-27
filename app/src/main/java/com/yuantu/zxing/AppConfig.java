package com.yuantu.zxing;

import com.yuantu.zxing.bean.ConfigBean;

/**
 * Author:  Yxj
 * Time:    2019/5/27 下午3:45
 * -----------------------------------------
 * Description:
 */
public class AppConfig {

    private AppConfig(){}

    private static AppConfig mInstance;

    public static AppConfig getInstance(){
        if(mInstance == null){
            synchronized (AppConfig.class){
                if(mInstance == null){
                    mInstance = new AppConfig();
                }
            }
        }
        return mInstance;
    }

    private ConfigBean configBean;

    public ConfigBean getConfigBean() {
        return configBean;
    }

    public void setConfigBean(ConfigBean configBean) {
        this.configBean = configBean;
    }
}
