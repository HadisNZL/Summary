package com.example.hadis.summary.activity;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.baidu.platform.comapi.map.L;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.example.hadis.summary.R;
import com.example.hadis.summary.base.BaseActivity;
import com.example.hadis.summary.utils.Blur;
import com.example.hadis.summary.utils.GlideUtil;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;

/**
 * 毛玻璃测试
 */
public class BlurActivity extends BaseActivity {
    @ViewInject(R.id.img_ss)
    private ImageView imageView;
    @ViewInject(R.id.img_ss11)
    private ImageView imageView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur);
        x.view().inject(this);
        initView();


    }

    /**
     *
     */
    private void initView() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.maoboli_img, options);
        Bitmap newImg = Blur.fastblur(BlurActivity.this, image, 25);
        imageView.setImageBitmap(newImg);
        String imgUrl = "http://ww2.sinaimg.cn/crop.0.0.1080.1080.1024/d773ebfajw8eum57eobkwj20u00u075w.jpg";

//        Glide.with(getApplicationContext()).load(imgUrl)
//                .asBitmap()
//                .centerCrop()
//                .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
//                    @Override
//                    public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
//                        //Bitmap newImg = Blur.fastblur(BlurActivity.this, resource, 25);
//                        imageView1.setImageBitmap(resource);
//                    }
//                });


        BitmapPool pool = Glide.get(getApplicationContext()).getBitmapPool();
        int width = GlideUtil.getDisplaySize(getApplicationContext()).x;
        int height = (int) GlideUtil.getDimens(getApplicationContext(), R.dimen.blur_width);
        Glide.with(this)
                .load(imgUrl)
                .centerCrop()
                .bitmapTransform(new BlurTransformation(getApplicationContext(), pool),
                        new CropTransformation(pool, width, height))
                .into(imageView1);

    }

}
