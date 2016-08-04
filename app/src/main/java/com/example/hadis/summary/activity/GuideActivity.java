package com.example.hadis.summary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.hadis.summary.R;
import com.example.hadis.summary.adapter.BasePagerAdapter;
import com.example.hadis.summary.base.BaseActivity;
import com.example.hadis.summary.utils.CreateShut;
import com.example.hadis.summary.utils.SharePrefenceUtil;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

/**
 * 第一次运行的引导页代码
 *
 * @author hadis on 16.3.11.
 */

public class GuideActivity extends BaseActivity implements OnPageChangeListener,
        OnClickListener {
    @ViewInject(R.id.viewpage)
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    @ViewInject(R.id.start_Button)
    private Button startButton;
    @ViewInject(R.id.indicator)
    private LinearLayout indicatorLayout;
    private ArrayList<View> views;
    private ImageView[] indicators = null;
    private int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        x.view().inject(this);
        // 创建桌面快捷方式
        new CreateShut(this);
        // 设置引导图片
        images = new int[]{R.drawable.welcome_01, R.drawable.welcome_02,
                R.drawable.welcome_03, R.drawable.welcome_04};
        initView();
    }

    private void initView() {
        startButton.setOnClickListener(this);
        views = new ArrayList<View>();
        indicators = new ImageView[images.length]; // 定义指示器数组大小
        for (int i = 0; i < images.length; i++) {
            // 循环加入图片
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(images[i]);
            views.add(imageView);
            // 循环加入指示器
            indicators[i] = new ImageView(this);
            indicators[i].setBackgroundResource(R.drawable.indicators_default);
            if (i == 0) {
                indicators[i].setBackgroundResource(R.drawable.indicators_now);
            }
            indicatorLayout.addView(indicators[i]);
        }
        pagerAdapter = new BasePagerAdapter(views);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.start_Button) {
            SharePrefenceUtil.setFirst(false);//把第一次进入boolean值改为false
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            // overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            this.finish();
        }
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onPageSelected(int arg0) {
        // 显示最后一个图片时显示按钮
        if (arg0 == indicators.length - 1) {
            startButton.setVisibility(View.VISIBLE);
        } else {
            startButton.setVisibility(View.INVISIBLE);
        }
        // 更改指示器图片
        for (int i = 0; i < indicators.length; i++) {
            indicators[arg0].setBackgroundResource(R.drawable.indicators_now);
            if (arg0 != i) {
                indicators[i]
                        .setBackgroundResource(R.drawable.indicators_default);
            }
        }
    }
}

