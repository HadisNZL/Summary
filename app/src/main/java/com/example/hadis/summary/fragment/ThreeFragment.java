package com.example.hadis.summary.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hadis.summary.R;
import com.example.hadis.summary.activity.MainSMActivity;
import com.example.hadis.summary.base.BaseFragment;

/**
 * Created by hadis on 16.3.10.
 */
public class ThreeFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
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
