package com.example.hadis.summary.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.hadis.summary.R;
import com.example.hadis.summary.adapter.MovieFragmentAdapter;
import com.example.hadis.summary.base.BaseFragment;
import com.example.hadis.summary.utils.ToastUtil;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hadis on 16.3.10.
 */
public class TwoFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    @ViewInject(R.id.movie_rgp)
    private RadioGroup radioGroup;
    @ViewInject(R.id.movie_viewpager)
    private ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        x.view().inject(this, view);
        initData();
        return view;
    }

    private void initData() {


        HFragment fragment1 = new HFragment();
        HHFragment fragment2 = new HHFragment();
        HHHFragment fragment3 = new HHHFragment();
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        MovieFragmentAdapter adapter = new MovieFragmentAdapter(getChildFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.rb1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.rb2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.rb3:
                viewPager.setCurrentItem(2);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        RadioButton rb = (RadioButton) radioGroup.getChildAt(position);
        rb.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
