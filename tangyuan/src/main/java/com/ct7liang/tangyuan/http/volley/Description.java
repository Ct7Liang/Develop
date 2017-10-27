package com.ct7liang.tangyuan.http.volley;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/25.
 *
 */
public class Description {

    public static String getDesc(String desc, String url, Map<String, String> map){
        StringBuilder sb = new StringBuilder(desc +  ": " + url);
        if (map != null){
            Iterator<String> iterator = map.keySet().iterator();
            int i = 1;
            while ((iterator.hasNext())){
                String k = iterator.next();
                String v = map.get(k);
                if (i == 1){
                    sb.append("?").append(k).append("=").append(v);
                }else{
                    sb.append("&").append(k).append("=").append(v);
                }
                i++;
            }
        }
        return sb.toString();
    }
}