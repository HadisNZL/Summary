package com.example.hadis.summary.activity;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;

import com.example.hadis.summary.R;
import com.example.hadis.summary.base.BaseActivity;
import com.example.hadis.summary.fragment.HFragment;
import com.example.hadis.summary.fragment.HHFragment;
import com.example.hadis.summary.fragment.HHHFragment;
import com.example.hadis.summary.view.PagerSlidingTabStrip;
import com.example.hadis.summary.view.ViewPagerCompat;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

public class BarActivity extends BaseActivity {
    @ViewInject(R.id.tabs)
    private PagerSlidingTabStrip tabs;
    @ViewInject(R.id.pager)
    private ViewPagerCompat pager;
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        x.view().inject(this);
        initView();
    }

    private void initView() {
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
        pager.setPageMargin(pageMargin);
        tabs.setViewPager(pager);
        tabs.setIndicatorColorResource(R.color.transparent);//下滑条颜色
        int size = (int) this.getResources().getDimension(R.dimen.tabTextSize);
        int size_select = (int) this.getResources().getDimension(R.dimen.tabTextSize_sel);
        tabs.setTextSize(size);//字体大小
        tabs.setDividerColorResource(R.color.transparent);//竖直分割线颜色
        tabs.setBackgroundResource(R.color.back_global_light);
        tabs.setTypeface(Typeface.create(Typeface.SERIF, Typeface.NORMAL), Typeface.NORMAL);//字体类型
        tabs.setSelectedTextColorResource(R.color.tiao_color);//选中字体颜色值
        tabs.setSelectedTabTextSize(size_select);//选中字体的大小
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return "热门";
            } else if (position == 1) {
                return "推荐";
            } else if (position == 2) {
                return "关注";
            }
            return "";
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) {//首页
                return HFragment.newInstance();
            }
            if (position == 1) {//首页
                return HHFragment.newInstance();
            }
            if (position == 2) {//首页
                return HHHFragment.newInstance();
            }
            return HFragment.newInstance();
        }

    }
}
