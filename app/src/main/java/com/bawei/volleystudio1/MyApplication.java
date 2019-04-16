package com.bawei.volleystudio1;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 */
public class MyApplication extends Application {

    //public static Application application;
    public static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        //application = this;
        queue = Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getRequestQueue(){
        return queue;
    }

}
