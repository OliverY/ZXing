package com.yuantu.zxing.config;

import com.yuantu.zxing.bean.ConfigBean;

/**
 * Author:  Yxj
 * Time:    2019/5/27 下午3:45
 * -----------------------------------------
 * Description: 应用的配置信息，服务端传的，用于配置项
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
