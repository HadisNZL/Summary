package com.example.hadis.summary.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.example.hadis.summary.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 类描述：对glide的简单封装
 *
 * @author hadis on 16.4.14.
 */
public class GlideUtil {


    /**
     * 最常用的   centerCrop
     * placeholder:可以是color 也可以是默认图片
     *
     * @param context
     * @param imgUrl
     * @param resourceId
     * @param view
     */
    public static void loadImgCenterCrop(Context context, String imgUrl, int resourceId, ImageView view) {
        Glide.with(context).load(imgUrl).centerCrop().placeholder(resourceId).into(view);
    }

    /**
     * fitCenter
     * placeholder:可以是color 也可以是默认图片
     *
     * @param context
     * @param imgUrl
     * @param resourceId
     * @param view
     */
    public static void loadImgFitCenter(Context context, String imgUrl, int resourceId, ImageView view) {
        Glide.with(context).load(imgUrl).fitCenter().placeholder(resourceId).into(view);
    }


    /**
     * centerCrop 带有动画效果 参数为Animation animation
     * placeholder:可以是color 也可以是默认图片
     *
     * @param context
     * @param imgUrl
     * @param resourceId
     * @param view
     */
    public static void loadImgCenterCropAnim(Context context, String imgUrl, Animation animation, int resourceId, ImageView view) {
        Glide.with(context).load(imgUrl).centerCrop().animate(animation).placeholder(resourceId).into(view);
    }

    /**
     * centerCrop 带有动画效果 参数为int animationId
     * placeholder:可以是color 也可以是默认图片
     *
     * @param context
     * @param imgUrl
     * @param resourceId
     * @param view
     */
    public static void loadImgCenterCropAnimId(Context context, String imgUrl, int animationId, int resourceId, ImageView view) {
        Glide.with(context).load(imgUrl).centerCrop().animate(animationId).placeholder(resourceId).into(view);
    }


    /**
     * 网络图片Url转换成BitMap   （可以加动画）
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void getBitMapFromUrl(final Context context, String url, final ImageView imageView) {

        Glide.with(context).load(url)
                .asBitmap()
                .fitCenter()
                .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
                    }
                });
    }


    /**
     * 获取屏幕尺寸
     *
     * @param context
     * @return
     */
    public static Point getDisplaySize(Context context) {
        Point point = null;
        if (null == point) {
            point = new Point();
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            wm.getDefaultDisplay().getSize(point);
        }
        return point;
    }

    /**
     * dimens
     *
     * @param context
     * @param resId
     * @return
     */
    public static float getDimens(Context context, int resId) {
        return context.getResources().getDimension(resId);
    }


}
