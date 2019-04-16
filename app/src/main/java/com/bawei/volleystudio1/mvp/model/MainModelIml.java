package com.bawei.volleystudio1.mvp.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.bawei.volleystudio1.net.VolleyHttp;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 */
public class MainModelIml implements MainModel {

    private boolean connected;

    @Override
    public void getData(final Context context, String url, final CallBackListener listener) {

        connected = VolleyHttp.getInstance().isNetWorkConnected(context);

        if (connected){

            VolleyHttp.getInstance().VolleyStringGet(url, new VolleyHttp.CallBack() {
                @Override
                public void success(String data) {
                    listener.success(data);
                }

                @Override
                public void fail(VolleyError error) {
                    listener.fail();
                }
            });

        }else {
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    Toast.makeText(context,"网路连接失败",Toast.LENGTH_SHORT).show();
                }
            };
        }

    }
}
