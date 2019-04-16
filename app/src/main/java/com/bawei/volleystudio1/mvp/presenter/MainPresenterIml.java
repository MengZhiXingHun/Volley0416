package com.bawei.volleystudio1.mvp.presenter;

import android.content.Context;

import com.bawei.volleystudio1.mvp.model.MainModel;
import com.bawei.volleystudio1.mvp.model.MainModelIml;
import com.bawei.volleystudio1.mvp.view.MainView;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 */
public class MainPresenterIml implements MainPresenter {

    private MainView mainView;
    private MainModelIml mainModelIml;

    @Override
    public void attch(MainView mainView) {
        mainModelIml = new MainModelIml();
        this.mainView = mainView;
    }

    @Override
    public void showData(Context context,String url) {
        mainModelIml.getData(context,url, new MainModel.CallBackListener() {
            @Override
            public void success(String data) {
                mainView.success(data);
            }

            @Override
            public void fail() {
                mainView.fail();
            }
        });
    }

    @Override
    public void detch() {
        if (mainModelIml != null){
            mainModelIml = null;
        }
        if (mainView != null){
            mainView = null;
        }
        System.gc();
    }
}
