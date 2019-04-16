package com.bawei.volleystudio1.mvp.presenter;

import com.bawei.volleystudio1.mvp.model.MainModelImpl;
import com.bawei.volleystudio1.mvp.view.MainView;
import com.bawei.volleystudio1.net.HttpUtil;

import java.util.Map;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 */
public class MainPresenterImpl implements IMainPresenter {

    private MainModelImpl mainModel;
    private MainView view;

    @Override
    public void attch(MainView view) {
        mainModel = new MainModelImpl();
        this.view = view;
    }

    @Override
    public void showData(String url, int method, Map<String, String> param) {
        mainModel.getData(url, method, param, new HttpUtil.Callback() {
            @Override
            public void onSuccess(Object o) {
                view.success(String.valueOf(o));
            }

            @Override
            public void onFail(Object o) {
                view.fail();
            }
        });
    }

    @Override
    public void detch() {

    }
}
