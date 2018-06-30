package com.yuantu.okhttp.utils;

import com.google.gson.Gson;
import com.yuantu.okhttp.ApiResponse;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Author:  Yxj
 * Time:    2018/6/30 上午10:33
 * -----------------------------------------
 * Description:
 */
public class GsonParserUtils {

    public static ApiResponse fromJson(String json, Class clazz) {
        Gson gson = new Gson();
        Type objectType = type(ApiResponse.class, clazz);
        return gson.fromJson(json, objectType);
    }

    static ParameterizedType type(final Class raw, final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return raw;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }
}
