package com.ct7liang.develop;

import android.view.View;

import com.android.volley.VolleyError;
import com.ct7liang.tangyuan.http.volley.VolleyErrorListener;
import com.ct7liang.tangyuan.http.volley.VolleyHelper;
import com.ct7liang.tangyuan.http.volley.VolleyListener;
import com.ct7liang.tangyuan.ui.ToastUtils;

public class MainActivity extends DemosActivity {

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void findView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initFinish() {

        VolleyHelper
                .getInstance()
                .desc("登录请求")
//                .url("http://114.115.222.38/biz/loginc/login")
                .url("http://sabrina.iask.in/xunbr_app_server/api/loginc/aplogin")
                .type(VolleyHelper.TYPE_GET_ID)
                .prams("account", "15638155615")
                .prams("password", "123")
                .prams("registrationId", "1104a897929fb5283f0")
                .doPost(new VolleyListener.OnSuccess() {
                    @Override
                    public void onSuccess(String json) {
                        ToastUtils.showStatic("onSuccess");
                        startActivityAndFinish(SecondActivity.class);
                    }
                }, new VolleyErrorListener.OnError() {
                    @Override
                    public void onError(VolleyError volleyError) {
                        ToastUtils.showStatic("onError");
                    }
                });

    }


    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyApp.getRefWatcher(this).watch(this);
    }
}