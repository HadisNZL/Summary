package com.example.hadis.summary.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.hadis.summary.base.BaseApplication;

/**
 * Toast工具类
 *
 * @author hadis on 16.3.14.
 */
public class ToastUtil {
    private static Toast mToast = null;

    public static void showToast(Activity context, String message, int time) {
        if (context != null) {
            Toast.makeText(context, message, time).show();
        }

    }


    public static void show(int msg) {
        show(BaseApplication.getInstance().getResources().getString(msg));
    }

    /**
     * 固定 duration
     *
     * @param msg
     */
    public static void show(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        } else if (BaseApplication.getInstance() == null) {
            return;
        }
        if (mToast == null) {
            mToast = Toast.makeText(BaseApplication.getInstance(), msg,
                    Toast.LENGTH_SHORT);
        } else {
            mToast.cancel();
            mToast = Toast.makeText(BaseApplication.getInstance(), msg,
                    Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }

    /**
     * 自定义 duration
     *
     * @param msg
     * @param duration
     */
    public static void show(String msg, int duration) {
        if (TextUtils.isEmpty(msg)) {
            return;
        } else if (BaseApplication.getInstance() == null) {
            return;
        }
        if (mToast == null) {
            mToast = Toast.makeText(BaseApplication.getInstance(), msg,
                    duration);
        } else {
            mToast.cancel();
            mToast = Toast.makeText(BaseApplication.getInstance(), msg,
                    duration);
        }
        mToast.setText(msg);
        mToast.show();
    }

    /**
     * @param msg      int
     * @param duration
     */
    public static void show(int msg, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(BaseApplication.getInstance(), msg,
                    duration);
        } else {
            mToast.cancel();
            mToast = Toast.makeText(BaseApplication.getInstance(), msg,
                    duration);
        }
        mToast.setText(msg);
        mToast.show();
    }


    /**
     * 自定义位置的toast
     *
     * @param context
     * @param showTime
     * @param layout
     * @param yoffset
     */
    public static void showToastLeaveMessage(Context context, int showTime,
                                             int layout, int yoffset) {
        if (BaseApplication.getInstance() == null) {
            return;
        }
        if (mToast == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(layout, null);
            Toast toast = new Toast(context);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, yoffset);
            toast.setDuration(showTime);
            toast.setView(view);
            toast.show();
        }

    }

}
