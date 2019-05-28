package com.yuantu.zxing.net;

/**
 * Author:  Yxj
 * Time:    2019/5/27 上午9:24
 * -----------------------------------------
 * Description:
 */
public class ApiConstants {

//    public static final String BASE_URL = "http://10.10.11.154:8090";
    public static final String BASE_URL = "http://47.99.141.133:8081";
//    public static final String BASE_URL = "http://39.96.84.195";

    public static final String PHONE_LOGIN = BASE_URL + "/jszx/api/login";

    public static final String GET_DEVICE_INFO_BY_SCAN = BASE_URL + "/jszx/api/getDeviceInfoByScan";

    public static final String LOGGING_SCHEDULE = BASE_URL + "/jszx/api/onward";   //登记进度

    public static final String GET_CONFIG_INFO = BASE_URL + "/jszx/api/getConfigInfo"; //获取配置信息

    public static final String GET_PRODUCE_PLAN_PROCESS = BASE_URL + "/jszx/api/producePlanProcess"; //获取生产计划信息

}
