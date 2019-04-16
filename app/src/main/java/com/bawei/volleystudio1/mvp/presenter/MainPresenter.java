package com.bawei.volleystudio1.mvp.presenter;

import android.content.Context;

import com.bawei.volleystudio1.mvp.view.MainView;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 */
public interface MainPresenter {

    void attch(MainView mainView);
    void showData(Context context,String url);
    void detch();

}
