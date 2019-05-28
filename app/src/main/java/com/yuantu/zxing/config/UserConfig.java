package com.yuantu.zxing.config;

import android.content.Context;
import android.content.SharedPreferences;

import com.yuantu.zxing.App;
import com.yuantu.zxing.Constants;

/**
 * Author:  Yxj
 * Time:    2019/5/28 上午8:22
 * -----------------------------------------
 * Description: 用户配置信息，本app所有
 */
public class UserConfig {

    private final SharedPreferences sp;
    public User user;

    private UserConfig(){

        sp = App.mInstance.getSharedPreferences(Constants.SharedPreference.SP_NAME_USER, Context.MODE_PRIVATE );
        user = new User();
        user.setEmail(sp.getString(Constants.SharedPreference.EMAIL,null));
        user.setPassword(sp.getString(Constants.SharedPreference.PASSWORD,null));
    }

    private static UserConfig mInstance;

    public static UserConfig getInstance(){
        if(mInstance==null){
            synchronized (UserConfig.class){
                if(mInstance == null){
                    mInstance = new UserConfig();
                }
            }
        }
        return mInstance;
    }


}
