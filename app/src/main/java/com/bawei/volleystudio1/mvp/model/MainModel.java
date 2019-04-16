package com.bawei.volleystudio1.mvp.model;

import android.content.Context;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 */
public interface MainModel {

    interface CallBackListener{
        void success(String data);
        void fail();
    }

    void getData(Context context,String url, CallBackListener listener);

}
