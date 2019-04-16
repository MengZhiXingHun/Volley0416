package com.bawei.volleystudio1.mvp.model;

import com.bawei.volleystudio1.net.HttpUtil;

import java.util.Map;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 */
public interface IMainModel {

    void getData(String url, int method, Map<String, String> param, HttpUtil.Callback callback);
}
