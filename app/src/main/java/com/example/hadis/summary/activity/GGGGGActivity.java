package com.example.hadis.summary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hadis.summary.R;
import com.example.hadis.summary.base.BaseActivity;

import org.xutils.view.annotation.Event;
import org.xutils.x;

public class GGGGGActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mall_fix_layout);
        x.view().inject(this);
    }

    @Event({R.id.img_01})
    private void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.img_01:
                Intent intent = new Intent(GGGGGActivity.this, MainSMActivity.class);
                setResult(RESULT_OK, intent);
                startActivityForResult(intent, 0);
                // finish();
                break;
        }
    }

}
