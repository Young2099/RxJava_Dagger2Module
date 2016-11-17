package com.demo.panguso.rxjava_dagger2.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.demo.panguso.rxjava_dagger2.app.App;
import com.demo.panguso.rxjava_dagger2.common.Contants;

/**
 * Created by ${yangfang} on 2016/11/17.
 */

public class SharedPreferencesUtil {

    /**
     * 保存变量值
     *
     * @param filName
     * @param key
     * @param value
     */
    public static void setBoolean(String filName, String key, boolean value) {
        SharedPreferences.Editor editor = App.getAppContext().getSharedPreferences(filName, Context.MODE_PRIVATE).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * 取值
     *
     * @param fileName
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBoolean(String fileName, String key, boolean defaultValue) {
        SharedPreferences preferences = App.getAppContext().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return preferences.getBoolean(key, defaultValue);
    }


    public static boolean getChannelData() {
        return getBoolean(Contants.APP_UER,Contants.INIT_DB,false);
    }

    public  static void saveChannelData(boolean flag){
        setBoolean(Contants.APP_UER,Contants.INIT_DB,flag);
    }
}
