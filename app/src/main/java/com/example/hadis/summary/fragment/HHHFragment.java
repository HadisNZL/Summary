package com.example.hadis.summary.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hadis.summary.R;
import com.example.hadis.summary.base.BaseFragment;

/**
 * @author hadis on 16.3.10.
 */
public class HHHFragment extends BaseFragment {

    public static HHHFragment newInstance() {
        HHHFragment f = new HHHFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hhh, container, false);
        return view;
    }
}
