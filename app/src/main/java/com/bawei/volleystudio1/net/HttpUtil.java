package com.bawei.volleystudio1.net;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bawei.volleystudio1.MyApplication;

import java.util.Map;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 * <p>
 * 和网络交互
 * 支持 get和post
 * <p>
 * url method param callback
 */
public class HttpUtil {

    /**
     * 网路请求分发方法
     * @param url
     * @param method
     * @param param
     * @return
     */
    public HttpUtil doHttp(String url, int method, Map<String, String> param) {
        switch (method) {
            case Request.Method.GET:
                get(url, method, param);
                break;
            case Request.Method.POST:
                post(url, method, param);
                break;
        }
        return this;
    }

    private void post(String url, int method, final Map<String, String> param) {
        StringRequest stringRequest = new StringRequest(method, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (callback != null) {
                    callback.onSuccess(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (callback != null) {
                    callback.onFail(error.getMessage());
                }
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return param;
            }
        };

        MyApplication.queue.add(stringRequest);
    }

    private void get(String url, int method, Map<String, String> param) {
        StringRequest stringRequest = new StringRequest(method, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (callback != null) {
                    callback.onSuccess(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (callback != null) {
                    callback.onFail(error.getMessage());
                }
            }
        });

        MyApplication.queue.add(stringRequest);
    }

    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public interface Callback<T, E> {
        void onSuccess(T t);

        void onFail(E e);
    }
}
