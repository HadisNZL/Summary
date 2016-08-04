package com.example.hadis.summary.activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.hadis.summary.R;
import com.example.hadis.summary.base.BaseActivity;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HandshakeCompletedListener;

public class CheckBoxActivity extends BaseActivity implements View.OnClickListener {

    private List<CheckBox> checkboxs = new ArrayList<CheckBox>();
    @ViewInject(R.id.checkbox_01)
    private CheckBox checkBox01;
    @ViewInject(R.id.checkbox_02)
    private CheckBox checkBox02;
    @ViewInject(R.id.checkbox_03)
    private CheckBox checkBox03;
    @ViewInject(R.id.checkbox_04)
    private CheckBox checkBox04;
    @ViewInject(R.id.checkbox_05)
    private CheckBox checkBox05;
    @ViewInject(R.id.checkbox_06)
    private CheckBox checkBox06;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        x.view().inject(this);
        checkBox01.setText("旅游");
        checkBox02.setText("打乒乓球");
        checkBox03.setText("看书");
        checkBox04.setText("踢足球");
        checkBox05.setText("学习");
        checkBox06.setText("玩耍");
        checkboxs.add(checkBox01);
        checkboxs.add(checkBox02);
        checkboxs.add(checkBox03);
        checkboxs.add(checkBox04);
        checkboxs.add(checkBox05);
        checkboxs.add(checkBox06);
        Button button = (Button) this.findViewById(R.id.btn_result);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        StringBuffer s = new StringBuffer();
        for (CheckBox box : checkboxs) {
            if (box.isChecked()) {
                if (s.length() > 0) {
                    s.append(",");
                }
                s.append(box.getText());
            }
        }
        if (s.length() == 0) {
            s.append("您还没有选择呢");
        }
        Log.i("ggg", s + "");
        //使用提示框提示用户信息
        new AlertDialog.Builder(this).setMessage(s.toString()).setPositiveButton("关闭", null).show();
    }
}
