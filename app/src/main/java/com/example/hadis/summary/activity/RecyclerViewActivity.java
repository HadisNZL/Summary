package com.example.hadis.summary.activity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import com.example.hadis.summary.R;
import com.example.hadis.summary.adapter.RecyclerViewAdapter;
import com.example.hadis.summary.base.BaseActivity;
import com.example.hadis.summary.bean.RecycBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hadis on 16.4.13.
 */
public class RecyclerViewActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {
    @ViewInject(R.id.recyclerView)
    private RecyclerView recyclerView;
    @ViewInject(R.id.swipeLayout)
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<RecycBean.DataBean.Data2Bean> list = new ArrayList<>();
    private RecyclerViewAdapter adapter;
    //private String result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        initView();
        initData();
    }

    private void initView() {
        x.view().inject(this);
        // 线性布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //默认不加本行代码 （只有横向时才添加）
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        adapter = new RecyclerViewAdapter(this, list);
        // 设置布局管理器
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setColorSchemeColors(R.color.yellow);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    private void initData() {
        String url = "http://www.ubetween.cn/api/video/list/pageno/0/pagesize/10";
        RequestParams params = new RequestParams(url);
        params.setCacheMaxAge(1000 * 60);
        x.http().get(params, new Callback.CacheCallback<String>() {
            private String result = null;

            @Override
            public boolean onCache(String result) {
                this.result = result;
                getDataToList(result);
                return true;
            }

            @Override
            public void onSuccess(String result) {
                this.result = result;
                getDataToList(result);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


//        x.http().get(params, new Callback.CommonCallback<String>() {
//
//            @Override
//            public void onSuccess(String result) {
//                Gson gson = new GsonBuilder().create();
//                RecycBean hahah = gson.fromJson(result, RecycBean.class);
//                list.addAll(hahah.getData().getData2());
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });
    }

    private void getDataToList(String result) {
        Gson gson = new GsonBuilder().create();
        RecycBean hahah = gson.fromJson(result, RecycBean.class);
        list.addAll(hahah.getData().getData2());
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
                list.clear();
                initData();
            }
        }, 1500);
    }
}
