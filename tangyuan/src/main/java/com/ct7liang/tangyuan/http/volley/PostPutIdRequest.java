package com.ct7liang.tangyuan.http.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.ct7liang.tangyuan.GuConstant;
import com.ct7liang.tangyuan.local_storage.SpUtils;
import com.ct7liang.tangyuan.test.LogUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/25.
 *
 */

class PostPutIdRequest extends StringRequest {

    private Map<String, String> params;
    private String description;

    PostPutIdRequest(String description, String url, Map<String, String> map, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.POST, url, listener, errorListener);
        this.params = map;
        this.description = description;
        LogUtils.write(Description.getDesc(description, url, map));
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        String sessionID = SpUtils.getInstance().getString(GuConstant.SESSION_ID);
        if (sessionID!=null && sessionID.length()>0) {
            HashMap<String, String> headers = new HashMap<>();
            headers.put("cookie", sessionID);
            LogUtils.write(description + "携带session_id访问: " + sessionID);
            return headers;
        }else {
            return super.getHeaders();
        }
    }
}
