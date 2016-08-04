package com.example.hadis.summary.daojishi;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/**
 * 原理:
 * 随时用SystemClock.elapsedRealtime()获取时间，使用这个时间来精确倒计时的数值
 */
public abstract class MyCountDownTimer {

    public static final int DAO_JI_SHI_MSG = 1;
    public static final int KAI_JIANG_ZHONG_MSG = 2;
    private long mSetTotalTime;// 例如：总的时间120000,120秒
    private long mSetDownValue;// 减少的值1000,1秒

    public MyCountDownTimer(long totalTime, long downValue) {
        this.mSetTotalTime = totalTime;
        this.mSetDownValue = downValue;
    }

    /**
     * 启动
     */
    public final synchronized MyCountDownTimer start() {
        if (mSetTotalTime <= 0) {
            onFinish();
            return this;
        }

        mStartTime = SystemClock.elapsedRealtime() + mSetTotalTime;// 开始的时间+开机到现在的时间
        mHandler.sendMessage(mHandler.obtainMessage(DAO_JI_SHI_MSG));
        return this;

    }

    ;

    /**
     * 变化的值
     */
    public abstract void onTick(long remain);

    public void cancel() {
        mHandler.removeMessages(DAO_JI_SHI_MSG);
    }

    /**
     * 结束之后
     */
    public abstract void onFinish();

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            synchronized (MyCountDownTimer.this) {

                long remain = mStartTime - SystemClock.elapsedRealtime();// 减少后，剩余的时间。
                if (remain <= 0) {
                    onFinish();// 完成
                } else if (mSetTotalTime < mSetDownValue) {
                    // 设置的值<down减少的值
                    sendMessageDelayed(obtainMessage(DAO_JI_SHI_MSG), remain);
                } else {
                    // 减少操作
                    long pre = SystemClock.elapsedRealtime();
                    onTick(remain);// 将值回调，供用户使用
                    long delay = pre + mSetDownValue
                            - SystemClock.elapsedRealtime();
                    while (delay < 0) {
                        delay += mSetDownValue;
                    }
                    sendMessageDelayed(obtainMessage(DAO_JI_SHI_MSG), delay);
                }
            }
        }

        ;

    };
    private long mStartTime;

}
