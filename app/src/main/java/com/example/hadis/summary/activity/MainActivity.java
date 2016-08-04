package com.example.hadis.summary.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hadis.summary.R;
import com.example.hadis.summary.base.AppManager;
import com.example.hadis.summary.base.BaseActivity;
import com.example.hadis.summary.base.BaseApplication;
import com.example.hadis.summary.fragment.FourFragment;
import com.example.hadis.summary.fragment.OneFragment;
import com.example.hadis.summary.fragment.RightFragment;
import com.example.hadis.summary.fragment.ThreeFragment;
import com.example.hadis.summary.fragment.TwoFragment;
import com.example.hadis.summary.utils.FragmentTabUtils;
import com.example.hadis.summary.widget.ExitCustomDialog;

import java.util.ArrayList;

/**
 * 主要Activity
 *
 * @author hadis on 16.3.10.
 */
public class MainActivity extends BaseActivity {
    private RadioGroup radioGroup;
    private ExitCustomDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragmentTabUtils();
    }

    private void initFragmentTabUtils() {
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());
        fragments.add(new FourFragment());
        new FragmentTabUtils(getSupportFragmentManager(), fragments, R.id.home_frame, radioGroup);
    }

    //private long oneTime = 0;

    @Override
    public void onBackPressed() {
        //  super.onBackPressed();
        ExitDialog(getString(R.string.exit_dialog_tip));
//        long twoTime = System.currentTimeMillis();
//        if (twoTime - oneTime > 2000) {
//            Toast.makeText(getApplication(), "再按一次，下的去手吗？", Toast.LENGTH_SHORT)
//                    .show();
//            oneTime = twoTime;
//        } else {
//            AppManager.getAppManager().AppExit(BaseApplication.getInstance());
//        }
    }

    private void ExitDialog(String message) {
        dialog = new ExitCustomDialog(this, R.style.Dialog,
                new ExitCustomDialog.LeaveMyDialogListener() {
                    @Override
                    public void onClick(View view) {
                        switch (view.getId()) {
                            case R.id.tv_relogin:
                                dialog.dismiss();
                                AppManager.getAppManager().AppExit(BaseApplication.getInstance());
                                break;
                            case R.id.tv_exit:
                                dialog.dismiss();
                                break;
                        }
                    }
                }, message, R.drawable.show_dialog_bg);
        dialog.show();
    }
}
