package com.ct7liang.tangyuan.http.volley;

import android.util.Log;

import com.android.volley.Response;
import com.ct7liang.tangyuan.test.LogUtils;

/**
 * Created by Administrator on 2017/10/25.
 *
 */
public class VolleyListener implements Response.Listener<String> {

    private OnSuccess listener;
    private String desc;

    public VolleyListener(OnSuccess listener){
        this.listener = listener;
    }

    public void setDesc(String str){
        desc = str;
    }

    @Override
    public void onResponse(String s) {
        LogUtils.write(desc + "返回数据: " + s);
        listener.onSuccess(s);
    }

    public interface OnSuccess{
        void onSuccess(String json);
    }

    public void unRegister(){
        listener = null;
        Log.e("listener", "listener置空");
    }
}