package com.ct7liang.tangyuan.ui;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.androidadvance.topsnackbar.TSnackbar;

/**
 * Created by Administrator on 2017/6/30.
 *  由上而下显示的snackBar
 */
public class TopSnackBarUtils {

    public static void showTopSnackBar(final Activity act, String content, final String showColor){
        TSnackbar tsb = TSnackbar.make(act.findViewById(android.R.id.content), content, TSnackbar.LENGTH_LONG);
        View snackBarView = tsb.getView();
        snackBarView.setBackgroundColor(Color.parseColor(showColor));
//        snackBarView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
//            @Override
//            public void onViewAttachedToWindow(View v) {
//                StatusBarUtil.setColor(act, Color.parseColor(showColor), 0);
//            }
//            @Override
//            public void onViewDetachedFromWindow(View v) {
//                StatusBarUtil.setColor(act, Color.parseColor(finishColor), 0);
//            }
//        });
        TextView textView = (TextView) snackBarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        tsb.show();
    }
}