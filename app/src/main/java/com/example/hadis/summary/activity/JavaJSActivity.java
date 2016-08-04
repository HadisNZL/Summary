package com.example.hadis.summary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.hadis.summary.R;
import com.example.hadis.summary.base.BaseActivity;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class JavaJSActivity extends BaseActivity {

    @ViewInject(R.id.webview)
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js);
        x.view().inject(this);
        callBack();
        setTitle("Java与JS交互");
        initView();
    }

    private void initView() {
        String detailsUrl = "http://www.ubetween.com.cn/product/detail/id/13/v/app";

        webView.requestFocusFromTouch();//需要用户手动输入用户名、密码或其他，则webview必须设置支持获取手势焦点

        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);// 隐藏缩放按钮
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);// 排版适应屏幕
        webSettings.setUseWideViewPort(true);// 可任意比例缩放
        webSettings.setLoadWithOverviewMode(true);// setUseWideViewPort方法设置webview推荐使用的窗口。setLoadWithOverviewMode方法是设置webview加载的页面的模式。
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);// 保存表单数据

        webSettings.setJavaScriptEnabled(true);//设定可以交互
        // webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);  //优先使用缓存
        // webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);  //不使用缓存
        webView.addJavascriptInterface(new JSBridge(), "android");
        webView.loadUrl(detailsUrl);


    }

    /**
     * js只能调用到JSBridge的方法， public 这样安全
     */
    public class JSBridge {
        @JavascriptInterface
        public void getjs(String message) {
             Toast.makeText(getApplicationContext(), "结果" + message, Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(getApplicationContext(), RetrofitActivity.class);
//            intent.putExtra("hh", message);
//            startActivity(intent);
        }
    }

//    public void test(String message) {
//        Toast.makeText(getApplicationContext(), "结果" + message, Toast.LENGTH_LONG).show();
//    }
//
//
//    @Event({R.id.web_btn})
//    private void btnOClcl(View view) {
//        if (view.getId() == R.id.web_btn) {
//            webView.loadUrl("javascript:dobuy()");
//        }
//    }
}
