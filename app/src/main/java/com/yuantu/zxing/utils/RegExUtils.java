package com.yuantu.zxing.utils;

import com.yuantu.zxing.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author:  Yxj
 * Time:    2018/7/2 下午10:52
 * -----------------------------------------
 * Description:
 */
public class RegExUtils {



//    public static void main(String[] args){
//        String str1 = "2-136-001-2018072-002";
//        System.out.println(isMaterial(str1));
//        String str2 = "1-136-001-20180702-0024";
//        System.out.println(isMaterial(str2));
//    }

    public static boolean isMaterial(String string){
        String regex = "^[1|2]-\\d{3}-\\d{3}-\\d{8}-\\d{3}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    /**
     * 校验barcode
     * @param string
     * @return {@link com.yuantu.zxing.Constants.MaterialType}
     */
    public static int checkCode(String string){
        String regex = "^[1|2]-\\d{3}-\\d{3}-\\d{8}-\\d{3}$";
        Pattern pattern = Pattern.compile(regex);
        if(pattern.matcher(string).matches()){
            if(string.startsWith("1")){
                return Constants.MaterialType.TYPE_PRODUCT;
            }else if(string.startsWith("2")){
                return Constants.MaterialType.TYPE_CHILD;
            }
        }
        return Constants.MaterialType.TYPE_NONE;
    }

}
