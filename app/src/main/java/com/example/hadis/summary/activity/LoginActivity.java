package com.example.hadis.summary.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.hadis.summary.R;
import com.example.hadis.summary.base.BaseActivity;
import com.example.hadis.summary.bean.LoginResultBean;
import com.example.hadis.summary.bean.RecycBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author hadis on 16.4.15.
 */
public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        //String url = "http://doctor.ubetween.com.cn/api/medicine/list/pagesize/4/pageno/0/order/zx";
        // String url = "http://account.ubetween.com/mobile/isreg/loginuser/15324316665/type/mobile";
        String url = "http://www.ubetween.cn/api/mobile/login/mobile/15324316660/pwd/123456";
        RequestParams params = new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                String ddd = result;
                Gson gson = new GsonBuilder().create();// Gson gson = new Gson();
                LoginResultBean hahah = gson.fromJson(result, LoginResultBean.class);//利用fromJson 从json字符串转到实体类 (最常用)
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

}
