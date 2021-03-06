package com.benchem.microserviceshub.sdk;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import jodd.util.StringPool;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class HttpInvokeHelper {
    public static String get(String protocol, String host, int port, String path, HashMap<String, Object> queryParam){
        Map<String, String> params = new HashMap<>();
        try {
            for (Map.Entry<String, Object> item : queryParam.entrySet()) {
                params.put(item.getKey(), URLEncoder.encode(item.getValue().toString(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            try {
                JSONObject errObj = new JSONObject();
                errObj.put("errcode", -1);
                errObj.put("errmsg", e.getMessage());
                return errObj.toString();
            } catch (JSONException e1) {
                e1.printStackTrace();
                return "";
            }
        }

        HttpRequest request = new HttpRequest();
        request
                .method("get")
                .protocol(protocol)
                .host(host)
                .port(port)
                .path(path)
                .query(params);
        HttpResponse response = request.send();
        return response.bodyText();
    }

    public static String post(String protocol, String host, int port, String uri, String postData){
        HttpRequest request = new HttpRequest();
        request
                .method("post")
                .protocol(protocol)
                .contentType("application/json", StringPool.UTF_8)
                .host(host)
                .port(port)
                .path(uri)
                .body(postData);
        HttpResponse response = request.send();
        return response.bodyText();
    }
}
