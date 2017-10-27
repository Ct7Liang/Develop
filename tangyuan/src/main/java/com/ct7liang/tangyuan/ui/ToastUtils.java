package com.ct7liang.tangyuan.ui;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/5/31.
 *
 */
public class ToastUtils {

    public static Context ctx;
    public static void init(Context context){
        ctx = context;
    }

    /**
     * 弹toast
     * @param msg 内容
     */
    public static void showShort(String msg) {
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 弹toast
     * @param msg 内容
     */
    public static void showLong(String msg) {
        Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show();
    }

    //静态Toast
    private static Toast sToast;
    /**
     * 弹出静态toast
     * @param msg 内容
     */
    public static void showStatic(String msg) {
        /*1. 第一次调用时  2.toast消失*/
        if (sToast == null) {
            sToast = Toast.makeText(ctx, msg, Toast.LENGTH_LONG);
        }
        sToast.setText(msg);
        sToast.show();
    }

}