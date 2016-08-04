package com.example.hadis.summary.daojishi;

import android.os.Handler;
import android.os.Message;

public class KjCountDownTimer extends MyCountDownTimer {
    private Handler mHandler;

    public KjCountDownTimer(long totalTime, long downValue) {
        super(totalTime, downValue);
    }

    public KjCountDownTimer(long totalTime, long downValue, Handler mHandler) {
        super(totalTime, downValue);
        this.mHandler = mHandler;
    }

    @Override
    public void onTick(long remain) {
        Message msg = new Message();
        msg.obj = new Long(remain);
        msg.what = DAO_JI_SHI_MSG;
        mHandler.sendMessage(msg);
    }

    @Override
    public void onFinish() {
        mHandler.sendEmptyMessage(KAI_JIANG_ZHONG_MSG);
    }

    /**
     * 处理时钟显示方式
     */
    public static String changeTimerFormat(long paramLong) {
        long l1 = paramLong / 86400000L;
        long l2 = paramLong % 86400000L / 3600000L;
        long l3 = paramLong % 3600000L / 60000L;
        if ((l1 == 0L) && (l2 > 0L)) {
            return l2 + "小时";
        }
        long l4 = paramLong % 60000L / 1000L;
        String str1 = String.valueOf(l3);
        String str2 = String.valueOf(l4);
        if (l3 < 10L) {
            str1 = "0" + l3;
        }
        if (l4 < 10L) {
            str2 = "0" + l4;
        }
        //return str1 + ":" + str2;//时钟方式
        return str2;//我这里改成了60秒
    }


}
