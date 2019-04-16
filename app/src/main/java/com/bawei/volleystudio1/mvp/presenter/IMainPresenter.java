package com.bawei.volleystudio1.mvp.presenter;

import com.bawei.volleystudio1.mvp.view.MainView;

import java.util.Map;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 */
public interface IMainPresenter {

    void attch(MainView view);

    void showData(String url, int method, Map<String, String> param);

    void detch();

}
