package com.example.hadis.summary.utils;

import com.example.hadis.summary.bean.LoLoginResultBean;
import com.example.hadis.summary.bean.LoginResultBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * @author hadis on 16.4.19.
 */
public class GsonUtil {

    private static Gson gson = null;

    static {
        if (gson == null) {
            gson = new Gson();
        }
    }

    private GsonUtil() {
    }

    public static Gson getGson() {
        Gson gson = new Gson();
        return gson;
    }

    /**
     * 转成json
     *
     * @param object
     * @return
     */
    public static String GsonString(Object object) {
        String gsonString = null;
        if (gson != null) {
            gsonString = gson.toJson(object);
        }
        return gsonString;
    }

    /**
     * 转成bean
     *
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> T GsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }

    /**
     * 转成list
     *
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
        List<T> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * //     * 获取T的实体类
     * //     *
     * //     * @param json
     * //     * @param typeOfT
     * //     * @param <T>
     * //     * @return
     * //
     */
//    public static <T> T getBeanTFromJson(String json, Class<T> cls) {
//        T bean_T = gson.fromJson(json, new TypeToken<T>() {
//        }.getType());
//        return bean_T;
//    }

}
