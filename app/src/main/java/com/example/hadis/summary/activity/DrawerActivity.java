package com.example.hadis.summary.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.hadis.summary.R;
import com.example.hadis.summary.base.BaseActivity;

public class DrawerActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

}
