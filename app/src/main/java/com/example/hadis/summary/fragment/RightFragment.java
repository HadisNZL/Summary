package com.example.hadis.summary.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.hadis.summary.R;
import com.example.hadis.summary.activity.LoginActivity;
import com.example.hadis.summary.activity.RegisterActivity;
import com.example.hadis.summary.base.BaseFragment;
import com.example.hadis.summary.utils.ToastUtil;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import static com.example.hadis.summary.utils.ToastUtil.*;

/**
 * @author hadis on 16.4.15.
 */
public class RightFragment extends BaseFragment {
    @ViewInject(R.id.login_enter)
    private Button loginBtn;
    @ViewInject(R.id.register_enter)
    private Button registerBtn;
    @ViewInject(R.id.button_mine_logout)
    private Button logoutBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right, container, false);
        x.view().inject(this, view);
        return view;
    }

    @Event(value = {R.id.login_enter, R.id.register_enter, R.id.button_mine_logout})
    private void onBtnClick(View v) {
        switch (v.getId()) {
            case R.id.login_enter:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.register_enter:
                startActivity(new Intent(getActivity(), RegisterActivity.class));
                break;
            case R.id.button_mine_logout:
                Toast.makeText(getActivity(), "退出登录", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
