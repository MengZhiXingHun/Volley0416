package com.bawei.volleystudio1.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bawei.volleystudio1.MyApplication;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 */
public class VolleyHttp {

    private VolleyHttp(){}

    private static VolleyHttp volleyHttp;

    public static VolleyHttp getInstance(){
        if (volleyHttp == null){
            synchronized (VolleyHttp.class){
                if (volleyHttp == null){
                    volleyHttp = new VolleyHttp();
                }
            }
        }
        return volleyHttp;
    }

    public boolean isNetWorkConnected(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();

        if (info != null){
            return info.isAvailable();
        }

        return false;
    }

    public void VolleyStringGet(String url, final CallBack back){

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        back.success(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        back.fail(error);
                    }
                });
        request.setTag("vollyget");

        MyApplication.getRequestQueue().add(request);

    }

    public interface CallBack{
        void success(String data);
        void fail(VolleyError error);
    }

}
