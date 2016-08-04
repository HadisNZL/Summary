package com.example.hadis.summary.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.hadis.summary.R;
import com.example.hadis.summary.activity.MainSMActivity;
import com.example.hadis.summary.base.BaseFragment;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * @author hadis on 16.4.15.
 */
public class LeftFragment extends BaseFragment {
    @ViewInject(R.id.btn_left)
    private Button btn;
    @ViewInject(R.id.btn02_left)
    private Button btn02;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        x.view().inject(this, view);
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "功能键", Toast.LENGTH_SHORT).show();
                switchFragment(new FourFragment(), "哈哈");
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "回到主页", Toast.LENGTH_SHORT).show();
                switchFragment(new OneFragment(), "哈哈");
            }
        });
        return view;
    }


    /**
     * 切换fragment
     */
    private void switchFragment(Fragment fragment, String title) {
        if (getActivity() == null) {
            return;
        }
        if (getActivity() instanceof MainSMActivity) {
            MainSMActivity fca = (MainSMActivity) getActivity();
            fca.switchConent(fragment, title);
        }
    }
}
