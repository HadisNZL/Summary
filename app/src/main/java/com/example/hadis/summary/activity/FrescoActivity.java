package com.example.hadis.summary.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hadis.summary.R;
import com.example.hadis.summary.base.BaseActivity;

import org.xutils.x;

public class FrescoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco);
        x.view().inject(this);
        callBack();
        setTitle("Fresco");
        initView();
    }

    private void initView() {
    
    }
}
