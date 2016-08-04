package com.example.hadis.summary.activity;

import android.os.Bundle;

import com.example.hadis.summary.R;
import com.example.hadis.summary.autoscrollviewpager.AutoScrollViewPager;
import com.example.hadis.summary.base.BaseActivity;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * @author hadis on 16.4.15.
 */
public class RegisterActivity extends BaseActivity {
    @ViewInject(R.id.view_pager_advert)
    private AutoScrollViewPager scrollViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        x.view().inject(this);
    }
}
