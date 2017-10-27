//package com.ct7liang.tangyuan.http.okhttp;
//
//import com.ct7liang.tangyuan.test.LogUtils;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.Cookie;
//import okhttp3.CookieJar;
//import okhttp3.FormBody;
//import okhttp3.HttpUrl;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.RequestBody;
//import okhttp3.Response;
//
///**
// * Created by Administrator on 2017/10/17.
// *
// */
//
//public class OkHttpHelper {
//
//    private OkHttpHelper(){}
//    private static OkHttpHelper okHttpHelper;
//    private static OkHttpClient okHttpClient;
//    public static OkHttpHelper getInstance(){
//        initOkHttpClient();
//        if (okHttpHelper == null){
//            okHttpHelper = new OkHttpHelper();
//        }
//        return okHttpHelper;
//    }
//
//    private static HashMap<String, List<Cookie>> cookieStore = new HashMap<>();
//
//    private static void initOkHttpClient() {
//        if (okHttpClient == null){
//            okHttpClient = new OkHttpClient
//                    .Builder()
//                    .cookieJar(new CookieJar() {
//                        @Override
//                        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
//                            LogUtils.write("保存cookie");
//                            cookieStore.put(httpUrl.host(), list);
//                        }
//                        @Override
//                        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
//                            List<Cookie> cookies = cookieStore.get(httpUrl.host());
//                            LogUtils.write("获取cookie");
//                            return cookies != null ? cookies : new ArrayList<Cookie>();
//                        }
//                    })
//                    .build();
//        }
//    }
//
//    /**
//     * post请求
//     * @param desc 访问描述
//     * @param url 访问url
//     * @param key 访问参数key数组
//     * @param value 访问参数value数组
//     * @param listener 访问结果监听者
//     */
//    public void doPost(final String desc, String url, String[] key, String[] value, final OnListener listener){
//        StringBuilder sb = new StringBuilder();
//        sb.append(desc).append(": ").append(url);
//        FormBody.Builder builder = new FormBody.Builder();
//        if (key!=null){
//            for (int i = 0; i < key.length; i++) {
//                builder.add(key[i], value[i]);
//                if (i == 0){
//                    sb.append("?").append(key[i]).append("=").append(value[i]);
//                }else{
//                    sb.append("&").append(key[i]).append("=").append(value[i]);
//                }
//            }
//        }
//        RequestBody requestBody = builder.build();
//        Request request = new Request.Builder()
//                .url(url)
//                .post(requestBody)
//                .build();
//        LogUtils.write(sb.toString());
//        okHttpClient.newCall(request).enqueue(new Callback() {   // enqueque 异步方法 不需要开启子线程
//            @Override
//            public void onFailure(Call call, IOException e) {
//                LogUtils.write(desc+"访问失败");
//                listener.onAsyFailure();
//            }
//            @Override
//            public void onResponse(Call call, final Response response) throws IOException {
////                okhttp 报java.lang.IllegalStateException: closed,java.lang.IllegalStateException:
////                OkHttp请求回调中response.body().string()只能有效调用一次
//                String string = response.body().string();
//                LogUtils.write(desc + "返回数据: " + string);
//                listener.onAsySuccess(string);
//            }
//        });
//    }
//
//    /**
//     * get请求
//     * @param desc 请求描述
//     * @param url 请求url
//     * @param listener 请求结果监听者
//     */
//    public void doGet(final String desc, String url, final OnListener listener){
//        Request request = new Request.Builder().url(url).build();
//        LogUtils.write(desc + ": " + url);
//        okHttpClient.newCall(request).enqueue(new Callback() {    // enqueque 异步方法 不需要开启子线程
//            @Override
//            public void onFailure(Call call, IOException e) {
//                LogUtils.write(desc+"访问失败");
//                listener.onAsyFailure();
//            }
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String responseStr = response.body().string();
//                LogUtils.write(desc + "返回: " + responseStr);
//                listener.onAsySuccess(responseStr);
//            }
//        });
//
//    }
//
//    public interface OnListener{
//        void onAsySuccess(String json);
//        void onAsyFailure();
//    }
//}