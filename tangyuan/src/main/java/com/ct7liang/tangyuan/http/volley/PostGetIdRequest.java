package com.ct7liang.tangyuan.http.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.ct7liang.tangyuan.GuConstant;
import com.ct7liang.tangyuan.local_storage.SpUtils;
import com.ct7liang.tangyuan.test.LogUtils;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/25.
 *
 */

class PostGetIdRequest extends StringRequest {

    private Map<String, String> params;
    private String description;

    PostGetIdRequest(String description, String url, Map<String, String> map, Response.Listener<String> listener, Response.ErrorListener errorListener) {
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
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        Response<String> superResponse = super.parseNetworkResponse(response);
        Map<String, String> responseHeaders = response.headers;
        String rawCookies = responseHeaders.get("Set-Cookie");
        if (rawCookies != null) {
            String sessionId = rawCookies.substring(0, rawCookies.indexOf(";"));
            LogUtils.write(description + "获取到SessionId: " + sessionId);
            SpUtils.getInstance().saveString(GuConstant.SESSION_ID, sessionId);
        }else{
            LogUtils.write(description + "没有获取到SessionId");
        }
        return superResponse;
    }
}
