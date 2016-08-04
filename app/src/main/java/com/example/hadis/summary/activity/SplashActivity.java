package com.example.hadis.summary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hadis.summary.R;
import com.example.hadis.summary.base.BaseActivity;
import com.example.hadis.summary.utils.SharePrefenceUtil;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import cn.jpush.android.api.JPushInterface;
import pl.droidsonroids.gif.GifImageView;

/**
 * 开屏页
 *
 * @author hadis on 16.3.10.
 */
public class SplashActivity extends BaseActivity {
    private boolean first;
    private static int TIME = 3000; // 进入主程序的延迟时间
    @ViewInject(R.id.gif_img)
    private GifImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        x.view().inject(this);
        // imageView.setImageResource(R.drawable.splash_bac1);
        imageView.setBackgroundResource(R.drawable.splash_bac02);//都可以加载动画
    }

    @Override
    protected void onResume() {
        JPushInterface.onResume(this);
        into(); // 进入主程序的方法
        super.onResume();
    }

    @Override
    protected void onPause() {
        JPushInterface.onPause(this);
        super.onPause();
    }

    private void into() {
        first = SharePrefenceUtil.getFirst(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (first) {
                    startActivity(new Intent(getApplicationContext(), GuideActivity.class));
                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
                //overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                finish();
            }
        }, TIME);
    }
}
