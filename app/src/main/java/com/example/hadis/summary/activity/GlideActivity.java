package com.example.hadis.summary.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hadis.summary.R;
import com.example.hadis.summary.base.BaseActivity;
import com.example.hadis.summary.utils.GlideUtil;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import pl.droidsonroids.gif.GifImageView;


/**
 * @author hadis on 16.4.14.
 */

public class GlideActivity extends BaseActivity {
    @ViewInject(R.id.img)
    private ImageView imgageView;
    @ViewInject(R.id.gif_img)
    private GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        x.view().inject(this);
        String imgUrl = "http://img.ugirls.com/uploads/cooperate/baidu/20160408jzx3.jpg";
        String gifUrl1 = "http://img0.ph.126.net/KHE-SOyfNPp7BGncUSwthw==/6630302505605947953.gif";
        // GlideUtil.loadImgCenterCrop(getApplicationContext(), gifUrl, R.color.white, imgageView);
        Glide.with(this).load(gifUrl1).into(imgageView);
    }
}
