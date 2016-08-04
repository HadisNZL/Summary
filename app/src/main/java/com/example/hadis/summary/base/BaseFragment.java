package com.example.hadis.summary.base;

import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * Created by hadis on 16.3.10.
 */
public class BaseFragment extends Fragment {

    public Toast mToast = null;

    public void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
}
