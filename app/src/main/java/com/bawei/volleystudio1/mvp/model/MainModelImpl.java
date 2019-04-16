package com.bawei.volleystudio1.mvp.model;

import com.bawei.volleystudio1.net.HttpUtil;

import java.util.Map;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 */
public class MainModelImpl implements IMainModel {

    private HttpUtil httpUtil;

    public MainModelImpl() {
        httpUtil = new HttpUtil();
    }

    @Override
    public void getData(String url, int method, Map<String, String> param , HttpUtil.Callback callback) {
        httpUtil.doHttp(url, method, param).setCallback(callback);
    }
}
