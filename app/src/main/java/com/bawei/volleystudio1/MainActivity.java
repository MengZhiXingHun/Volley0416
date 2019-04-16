package com.bawei.volleystudio1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.bawei.volleystudio1.bean.JsonBean;
import com.bawei.volleystudio1.mvp.presenter.MainPresenterIml;
import com.bawei.volleystudio1.mvp.presenter.MainPresenterImpl;
import com.bawei.volleystudio1.mvp.view.MainView;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenterIml mainPresenterIml = new MainPresenterIml();
    private MainPresenterImpl mainPresenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenterIml.attch(this);
        String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?&page=1&count=30&keyword=%E7%94%B7%E9%9E%8B";
        mainPresenterIml.showData(MainActivity.this,url);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

    }

    @Override
    public void success(String data) {

        JsonBean jsonBean = new Gson().fromJson(data, JsonBean.class);
        List<JsonBean.ResultBean> result = jsonBean.getResult();

        RecyclerAdapter adapter = new RecyclerAdapter(MainActivity.this,result);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void fail() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenterIml.detch();
    }
}
