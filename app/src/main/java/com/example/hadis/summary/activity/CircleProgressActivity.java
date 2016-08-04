package com.example.hadis.summary.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.hadis.summary.R;
import com.example.hadis.summary.base.BaseActivity;
import com.example.hadis.summary.daojishi.KjCountDownTimer;
import com.example.hadis.summary.utils.MyRecorder;
import com.example.hadis.summary.view.DonutProgress;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;
import java.io.IOException;


public class CircleProgressActivity extends BaseActivity {

    //录音
    private MyRecorder recorder;
    private static int RECORD_NO = 301; // 不在录音
    private static int RECORD_ING = 101; // 正在录音
    private static int RECODE_ED = 201; // 完成录音
    private static int RECODE_STATE = 0; // 录音的状态

    // 播放录音
    private MediaPlayer media;

    //倒计时相关
    @ViewInject(R.id.time_tv)
    private TextView mTimer;
    private long mSetTotalTime = 60000;// 总的时间120000,120秒
    private long mSetDownValue = 1000;// 减少的值1000,1秒
    private KjCountDownTimer kJCountDownTimer;
    private static final int DAO_JI_SHI_MSG = 1;//倒计时
    private static final int TIME_END_MSG = 2;//时间走完
    private static final int LISTEN_TIME_MSG = 110;//试听时间进度
    private String showTimer = "";

    //圆圈进度条
    @ViewInject(R.id.doutttt)
    private DonutProgress donutProgress;

    private boolean clickstate = false; //点击状态

    private static boolean playState = false; // 播放状态

    private static boolean isTrue = false;//是否中断线程


    // 更新进度条的线程
    private Thread barThread;


    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DAO_JI_SHI_MSG:
                    showTimer = KjCountDownTimer.changeTimerFormat(Long.parseLong(msg.obj.toString()));
                    int times = Integer.valueOf(showTimer).intValue() + 1;
                    int timestart = 60 - times;
                    mTimer.setText(timestart + "〃");
                    if (timestart != 0) {
                        donutProgress.setProgress(timestart + 1);
                    }
                    Log.i("saas", timestart + "");
                    break;
                case TIME_END_MSG:
                    kJCountDownTimer.cancel();
                    donutProgress.setText("录完了");
                    mTimer.setText("60〃");
                    donutProgress.setProgress(61);
                    clickstate = false;
                    VoiceStop();//60秒结束自动停止录音
                    break;

                case LISTEN_TIME_MSG:
                    if (!isTrue) {
                        donutProgress.setProgress(((int) media.getCurrentPosition()));
                        mTimer.setText(media.getDuration() + "〃");
                    }
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_progress);
        x.view().inject(this);
        callBack();
        setTitle("圆圈进度条");
        initView();
    }

    private void initView() {
        kJCountDownTimer = new KjCountDownTimer(mSetTotalTime, mSetDownValue, mHandler);
    }

    @Event({R.id.doutttt, R.id.send_btn, R.id.chonglu_btn})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.doutttt:
                if ((RECODE_STATE != RECORD_ING) && (RECODE_STATE != RECODE_ED)) {
                    RECODE_STATE = RECORD_ING;
                    Log.i("llly", "开始录音");
                    mTimer.setText("0〃");
                    kJCountDownTimer.start();
                    donutProgress.setText("进行中");
                    donutProgress.setMax(61);
                    VoiceStart();//开始录音
                } else if (RECODE_STATE == RECORD_ING) {
                    RECODE_STATE = RECODE_ED;
                    Log.i("llly", "录音结束");
                    kJCountDownTimer.cancel();
                    donutProgress.setText("录完了");
                    VoiceStop();//录音结束
                } else if (RECODE_STATE == RECODE_ED) {//试听
                    isTrue = false;
                    toPlayVoice();
                }
                break;
            case R.id.send_btn:
                showToast("发送");
                break;
            case R.id.chonglu_btn:
                RECODE_STATE = RECORD_NO;
                isTrue = true;
                donutProgress.setText("录音");
                donutProgress.setProgress(0);
                mTimer.setText("0〃");
                if (media != null) {
                    media.stop();
                }
                break;
        }

    }

    /**
     * 判断播放录音
     */
    private void toPlayVoice() {
        // 如果不是正在播放
        if (!playState) {
            // 实例化MediaPlayer对象
            media = new MediaPlayer();
            File file = new File(Environment.getExternalStorageDirectory(), "myvoice/voice.amr");
            try {
                // 设置播放资源
                media.setDataSource(file.getAbsolutePath());
                // 准备播放
                media.prepare();
                // 开始播放
                media.start();
                donutProgress.setText("试听中");
                donutProgress.setMax(((int) media.getDuration()));
                if (!isTrue) {
                    barUpdate();
                }
                // 改变播放的标志位
                playState = true;
                // 设置播放结束时监听
                media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        if (playState) {
                            playState = false;
                        }
                    }
                });
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // 如果正在播放
            if (media.isPlaying()) {
                media.stop();
                playState = false;
            } else {
                playState = false;
            }

        }

    }


    /**
     * 进度条线程
     */
    private void barUpdate() {
        barThread = new Thread(BarUpdateThread);
        barThread.start();
    }

    /**
     * 进度条更新线程
     */
    private Runnable BarUpdateThread = new Runnable() {
        @Override
        public void run() {
            for (donutProgress.getProgress(); donutProgress.getProgress() <= donutProgress.getMax(); ) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mHandler.sendEmptyMessage(LISTEN_TIME_MSG);
            }
        }
    };

    /**
     * 录音开始
     */
    private void VoiceStart() {
        recorder = new MyRecorder("voice");
        //  recorder = new MyRecorder(System.currentTimeMillis()+"");
        // 开始录音
        recorder.start();
    }


    /**
     * 录音结束
     */
    private void VoiceStop() {
        // 停止录音
        if (recorder != null) {
            recorder.stop();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        kJCountDownTimer.cancel();
        if (playState) {
            playState = false;
            media.stop();
        }
    }
}

