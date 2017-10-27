package com.ct7liang.tangyuan.http.volley;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.ct7liang.tangyuan.test.LogUtils;

/**
 * Created by Administrator on 2017/10/25.
 *
 */
public class VolleyErrorListener implements Response.ErrorListener {

    private OnError listener;
    private String desc;

    public VolleyErrorListener(OnError listener) {
        this.listener = listener;
    }

    public void setDesc(String str){
        desc = str;
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        LogUtils.write(desc + "请求异常: " + volleyError.toString());
        listener.onError(volleyError);
    }

    public interface OnError{
        void onError(VolleyError volleyError);
    }

    public void unRegister(){
        listener = null;
        Log.e("listener", "listener置空");
    }
}
