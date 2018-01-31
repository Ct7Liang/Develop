package com.ct7liang.tangyuan.test;

import android.util.Log;

/**
 * Created by Administrator on 2017/7/30.
 *  Log打印工具
 */
public class LogUtils {

    private static boolean isShowLog = true;

    private static String TAG = "Ct7";

    public static void setIsShowLog(boolean isShow){
        isShowLog = isShow;
    }

    /**
     *  项目流程打印
     * @param message 信息
     */
    public static void write(String message){
        if (isShowLog){
            Log.e(TAG, message);
        }
    }
}