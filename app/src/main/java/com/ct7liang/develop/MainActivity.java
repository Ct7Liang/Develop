package com.ct7liang.develop;

import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.ct7liang.tangyuan.BaseActivity;
import com.ct7liang.tangyuan.BaseApp;
import com.ct7liang.tangyuan.test.LogUtils;
import com.ct7liang.tangyuan.ui.ToastUtils;

public class MainActivity extends BaseActivity {

//    private VolleyListener onSuccess;
//    private VolleyListener Success;
//    private VolleyErrorListener onError;
//    private VolleyErrorListener Error;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            ToastUtils.showLong("desggrgeregr");
        }
    };

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public BaseApp addBaseApp() {
        return MyApp.getAppContext();
    }

    @Override
    public void findView() {
        findViewById(R.id.id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityAndFinish(SecondActivity.class);
                mHandler.sendEmptyMessageDelayed(0, 5500);
            }
        });
    }

    @Override
    public void initData() {
//        onSuccess = new VolleyListener(new VolleyListener.OnSuccess() {
//            @Override
//            public void onSuccess(String json) {
//                ToastUtils.showStatic("onSuccess");
//            }
//        });
//        onError = new VolleyErrorListener(new VolleyErrorListener.OnError() {
//            @Override
//            public void onError(VolleyError volleyError) {
//                ToastUtils.showStatic("onError");
//            }
//        });
//
//        Success = new VolleyListener(new VolleyListener.OnSuccess() {
//            @Override
//            public void onSuccess(String json) {
//                ToastUtils.showStatic("onSuccess");
//            }
//        });
//        Error = new VolleyErrorListener(new VolleyErrorListener.OnError() {
//            @Override
//            public void onError(VolleyError volleyError) {
//                ToastUtils.showStatic("onError");
//            }
//        });
    }

    @Override
    public void initView() {

    }

    @Override
    public void initFinish() {

//        VolleyHelper
//                .getInstance()
//                .desc("登录请求")
//                .url("http://114.115.222.38/biz/loginc/login")
//                .type(VolleyHelper.TYPE_GET_ID)
//                .prams("account", "18736607330")
//                .prams("password", "123")
//                .doPost(new VolleyListener.OnSuccess() {
//                    @Override
//                    public void onSuccess(String json) {
//                        ToastUtils.showStatic("onSuccess");
//                        startActivityAndFinish(SecondActivity.class);
//                    }
//                }, new VolleyErrorListener.OnError() {
//                    @Override
//                    public void onError(VolleyError volleyError) {
//                        ToastUtils.showStatic("onError");
//                    }
//                });

//        VolleyHelper
//                .getInstance()
//                .desc("验证手机号码")
//                .url(" http://sabrina.iask.in/xunbr_app_server/api/loginc/check")
//                .type(VolleyHelper.TYPE_GET_ID)
//                .prams("account", "18736607332")
//                .doPost(new VolleyListener.OnSuccess() {
//                    @Override
//                    public void onSuccess(String json) {
//                        ToastUtils.showStatic("onSuccess");
//                    }
//                }, new VolleyErrorListener.OnError() {
//                    @Override
//                    public void onError(VolleyError volleyError) {
//                        ToastUtils.showStatic("onError");
//                    }
//                });

//        StringRequest request = new StringRequest(
//                StringRequest.Method.POST,
//                "http://114.115.222.38/biz/loginc/login",
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String s) {
//                        ToastUtils.showStatic("onSuccess");
//                        startActivityAndFinish(SecondActivity.class);
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError volleyError) {
//                        ToastUtils.showLong("登录失败");
//                    }
//                }
//        ){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> map = new HashMap<>();
//                map.put("account", "18736607330");
//                map.put("password", "123");
//                return map;
//            }
//            @Override
//            protected Response<String> parseNetworkResponse(NetworkResponse response) {
//                Response<String> superResponse = super.parseNetworkResponse(response);
//                Map<String, String> responseHeaders = response.headers;
//                String rawCookies = responseHeaders.get("Set-Cookie");
//                if (rawCookies != null) {
//
//                }
//                return superResponse;
//            }
//        };
//        request.setRetryPolicy(new DefaultRetryPolicy(30*1000,0,0f));
//        Volley.newRequestQueue(this).add(request);

    }


    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onDestroy() {
        LogUtils.write("finish");
        super.onDestroy();
        MyApp.getRefWatcher(this).watch(this);
    }
}