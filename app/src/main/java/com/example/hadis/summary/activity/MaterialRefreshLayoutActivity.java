package com.example.hadis.summary.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.hadis.summary.R;
import com.example.hadis.summary.adapter.RefreshLayoutAdapter;
import com.example.hadis.summary.base.BaseActivity;
import com.example.hadis.summary.bean.VideoBean;
import com.example.hadis.summary.bean.VideoDeatils;
import com.example.hadis.summary.refresh.MaterialRefreshLayout;
import com.example.hadis.summary.refresh.MaterialRefreshListener;
import com.example.hadis.summary.utils.GsonUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class MaterialRefreshLayoutActivity extends BaseActivity {

    @ViewInject(R.id.refresh)
    private MaterialRefreshLayout refreshLayout;

    @ViewInject(R.id.gridview)
    private ListView gridView;
    private RefreshLayoutAdapter adapter;
    private List<VideoDeatils> list = new ArrayList<>();

    private int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_refresh_layout);
        x.view().inject(this);
        initView();
        initData();
    }

    private void initView() {
        adapter = new RefreshLayoutAdapter(list, getApplicationContext());
        gridView.setAdapter(adapter);
//        int[] color = {getResources().getColor(R.color.green)};
//        refreshLayout.setProgressColors(color);
        refreshLayout.autoRefresh();
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page = 0;
                        list.clear();
                        initData();
                        materialRefreshLayout.finishRefresh();
                    }
                }, 1200);
            }

            @Override
            public void onfinish() {
                showToast("完成刷新");
            }

            @Override
            public void onRefreshLoadMore(final MaterialRefreshLayout materialRefreshLayout) {
                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page += 1;
                        initData();
                        materialRefreshLayout.finishRefreshLoadMore();

                    }
                }, 500);
            }
        });
    }


    private void initData() {
        String url = "http://www.ubetween.cn/api/video/list/pageno/" + String.valueOf(page) + "/pagesize/10";
        RequestParams params = new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                VideoBean videoBean = GsonUtil.GsonToBean(result, VideoBean.class);
                list.addAll(videoBean.getData().getData2());
                adapter.notifyDataSetChanged();
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
    }


}
