package com.example.hadis.summary.base;

import android.app.Application;
import android.app.Notification;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.example.hadis.summary.R;

import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;

/**
 * @author by hadis on 16.3.10.
 */
public class BaseApplication extends Application {
    public static BaseApplication app;
    public static ImageOptions imageOptions;

    @Override
    public void onCreate() {
        super.onCreate();

        //极光推送全局初始化
        JPushInterface.setDebugMode(true);    // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);            // 初始化 JPush

        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());

        app = this;
        x.Ext.init(this);//初始化xutils3.x
        x.Ext.setDebug(true);// 是否输出debug日志
        initImageOptions();
    }


    public static BaseApplication getInstance() {
        return app;
    }

    public static ImageOptions getImageOptions() {
        return imageOptions;
    }

    private void initImageOptions() {
        imageOptions = new ImageOptions.Builder()
                // 图片大小
//                .setSize(DensityUtil.dip2px(240), DensityUtil.dip2px(200))
//                .setSize(DensityUtil.getScreenWidth(), ((DensityUtil.getScreenWidth() * 9) / 16))
                // ImageView圆角半径
                .setRadius(DensityUtil.dip2px(8))
                // 如果ImageView的大小不是定义为wrap_content, 不要crop.
                .setCrop(true)
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setLoadingDrawableId(R.color.white)// 加载中默认显示图片
                .setFailureDrawableId(R.color.white)// 加载失败后默认显示图片
                .build();
    }

    /**
     * 此方法描述的是： 复制内容到剪贴板
     */
    public static void copyContent(String content, Context context) {
        ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        cmb.setText(content.trim());
        Toast.makeText(context, "已复制到剪贴板", Toast.LENGTH_SHORT).show();
    }

}
