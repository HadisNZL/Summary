package com.example.hadis.summary.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.hadis.summary.R;
import com.example.hadis.summary.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;


public class RxJavaAndRetrofitActivity extends BaseActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_and_retrofit);
        ButterKnife.bind(this);
        initToolBar();
    }

    private void initToolBar() {
        toolbar.setTitle("详情");//setSupportActionBar之前调用
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//显示返回按钮
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                RxJavaAndRetrofitActivity.this.finish();
                break;
        }
        return true;
    }
}