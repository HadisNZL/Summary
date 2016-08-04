package com.example.hadis.summary.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hadis.summary.R;

/**
 * 自定义dialog （扩展性高）
 *
 * @author hadis on 16.3.10.
 */
public class ExitCustomDialog extends Dialog implements
        View.OnClickListener {

    private LeaveMyDialogListener listener;
    private Context context;
    private TextView tv_relogin;
    private TextView tv_exit;
    private TextView tips;
    private String message;
    private ImageView show_img;
    private int resid;
    private LinearLayout cancel_linear;
    private LinearLayout exit_linear;

    public ExitCustomDialog(Context context) {
        super(context);
        this.context = context;
    }

    public ExitCustomDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    public interface LeaveMyDialogListener {
        public void onClick(View view);
    }

    public ExitCustomDialog(Context context, int theme,
                            LeaveMyDialogListener listener, String message, int resid) {
        super(context, theme);
        this.context = context;
        this.listener = listener;
        this.message = message;
        this.resid = resid;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.exit_pop_layout);
        cancel_linear = (LinearLayout) findViewById(R.id.cancel_linear);
        exit_linear = (LinearLayout) findViewById(R.id.exit_linear);
        tv_relogin = (TextView) findViewById(R.id.tv_relogin);
        tv_exit = (TextView) findViewById(R.id.tv_exit);
        tips = (TextView) findViewById(R.id.tv_modefy_ok);
        tips.setText(message);
        show_img = (ImageView) findViewById(R.id.show_img);
        show_img.setBackgroundResource(resid);
        tv_relogin.setOnClickListener(this);
        tv_exit.setOnClickListener(this);
        cancel_linear.setOnClickListener(this);
        exit_linear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listener.onClick(v);
    }
}
