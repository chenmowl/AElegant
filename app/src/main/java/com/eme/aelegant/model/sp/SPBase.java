package com.eme.aelegant.model.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * Created by luokaiwen on 15/5/19.
 * <p/>
 * SharedPreference基类
 */
public class SPBase {

    protected static final String TAG = SPBase.class.getSimpleName();

    /**
     * 获取存储的内容
     * @return
     */
    public static String getContent(Context context,  String fileName, String key) {
        if (null == key) {
            return "";
        }
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sp.getString(key, "");
    }

    public  static boolean getBoolean(Context context, String fileName, String key){

        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sp.getBoolean(key,false);
    }


    public  static int getIntContent(Context context, String fileName, String key){

        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sp.getInt(key,0);
    }

    /**
     * 保存存储的内容
     */
    public static void setContent(Context context, String fileName, String key, String content) {

        if (null == context) {
            return;
        }

        if (TextUtils.isEmpty(content)) {
            content = "";
        }

        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        sp.edit().putString(key, checkContent(content)).commit();
    }

    /**
     * 保证内容不为null
     *
     * @param content
     * @return
     */
    private static String checkContent(String content) {

        if (TextUtils.isEmpty(content)) {
            return "";
        }

        return content;
    }

    public static void setSPBoolean(Context context, String fileName, String key, boolean var){
        if (null == context) {
            return;
        }
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, var).commit();
    }

    public static void setSPIn(Context context, String fileName, String key, int var){
        if (null == context) {
            return;
        }
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        sp.edit().putInt(key, var).commit();
    }
}
