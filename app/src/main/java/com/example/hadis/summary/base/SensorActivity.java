package com.example.hadis.summary.base;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hadis.summary.R;
import com.example.hadis.summary.activity.ParallaxSwipeBackActivity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 扬声器和听筒声音自动转化activity
 * <p/>
 * 根据距离传感器实时监听变化
 * <p/>
 * 使用方法 ：在听录音的Activity 继承本activity即可
 *
 * @author hadis on 16.06.16
 */
public class SensorActivity extends ParallaxSwipeBackActivity implements SensorEventListener {

    private AudioManager audioManager;//音频管理器
    private SensorManager mSensorManager;//传感器管理器
    private Sensor mSensor;//距离感应器实例

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        initView();
    }

    private void initView() {
        //得到距离感应器的实例
        audioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

    }

    @Override
    protected void onResume() {
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
        super.onResume();
    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(this);
        super.onPause();

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float range = event.values[0];
        float fixed_value = 0.0f;//贴近传感器的值
        if (range == fixed_value) {
            setInCallBySdk();//听筒模式
        } else {
            setModeNormal();//正常模式
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    /**
     * 正常模式
     */
    private void setModeNormal() {
        Toast.makeText(this, "正常模式", Toast.LENGTH_LONG).show();
        if (audioManager == null) {
            return;
        }
        audioManager.setSpeakerphoneOn(true);
        audioManager.setMode(AudioManager.MODE_NORMAL);

        if (!audioManager.isSpeakerphoneOn()) {
            audioManager.setSpeakerphoneOn(true);

            audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL,
                    audioManager.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL),
                    AudioManager.STREAM_VOICE_CALL);
        }
    }

    /**
     * 听筒模式
     */
    private void setInCallBySdk() {
        Toast.makeText(this, "听筒模式", Toast.LENGTH_LONG).show();
        if (audioManager == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (audioManager.getMode() != AudioManager.MODE_IN_COMMUNICATION) {
                audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
            }
            try {
                Class clazz = Class.forName("android.media.AudioSystem");
                Method m = clazz.getMethod("setForceUse", new Class[]{int.class, int.class});
                m.invoke(null, 1, 1);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            if (audioManager.getMode() != AudioManager.MODE_IN_CALL) {
                audioManager.setMode(AudioManager.MODE_IN_CALL);
            }
        }
        if (audioManager.isSpeakerphoneOn()) {
            audioManager.setSpeakerphoneOn(false);
            audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, audioManager.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL),
                    AudioManager.STREAM_VOICE_CALL);
        }
    }
}
