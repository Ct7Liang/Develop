package com.ct7liang.tangyuan.http.volley;

import com.android.volley.DefaultRetryPolicy;
import com.ct7liang.tangyuan.BaseApp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/25.
 *   Volley操作工具类
 */
public class VolleyHelper {

    private VolleyHelper(){}
    public static VolleyHelper getInstance(){
        return new VolleyHelper();
    }

    public VolleyHelper url(String url){
        setUrl(url);
        return this;
    }

    private String url;
    private void setUrl(String url){
        this.url = url;
    }

    private Map<String, String> params;
    public VolleyHelper prams(String key, String value){
        if (params==null){
            params = new HashMap<>();
        }
        params.put(key, value);
        return this;
    }

    public static final int TYPE_GET_ID = 0;  //等待获取sessionId
    public static final int TYPE_PUT_ID = 1;  //携带sessionId访问
    private int type = 0;
    public VolleyHelper type(int typeId){
        type = typeId;
        return this;
    }

    private String description;
    public VolleyHelper desc(String desc){
        description = desc;
        return this;
    }

    private VolleyListener listener;
    private VolleyErrorListener errorListener;

    public VolleyHelper doPost(VolleyListener.OnSuccess success, VolleyErrorListener.OnError error){
        listener = new VolleyListener(success);
        errorListener = new VolleyErrorListener(error);
        listener.setDesc(description);
        errorListener.setDesc(description);
        if (type == TYPE_GET_ID){
            PostGetIdRequest request = new PostGetIdRequest(
                    description,
                    url,
                    params,
                    listener,
                    errorListener
            );
            request.setRetryPolicy(new DefaultRetryPolicy(10*1000,0,0f));
            BaseApp.getRequestQueue().add(request);
        }else{
            PostPutIdRequest request = new PostPutIdRequest(
                    description,
                    url,
                    params,
                    listener,
                    errorListener
            );
            request.setRetryPolicy(new DefaultRetryPolicy(10*1000,0,0f));
            BaseApp.getRequestQueue().add(request);
        }
        return this;
    }

    protected void destroy(){
        listener.unRegister();
        errorListener.unRegister();
    }

    /**
     * 对外提供消除内存泄漏
     * @param volleyHelpers
     */
    public static void OnDestroy(VolleyHelper... volleyHelpers){
        for (int i = 0; i < volleyHelpers.length; i++) {
            if (volleyHelpers[i] != null){
                volleyHelpers[i].destroy();
            }
        }
    }
}