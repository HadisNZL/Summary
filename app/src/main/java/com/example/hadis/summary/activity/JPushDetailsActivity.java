package com.example.hadis.summary.activity;

import
        android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.hadis.summary.R;
import com.example.hadis.summary.base.BaseActivity;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class JPushDetailsActivity extends BaseActivity {
    @ViewInject(R.id.webview)
    private WebView webView;

    @ViewInject(R.id.titile)
    private TextView title11;
    @ViewInject(R.id.content)
    private TextView content11;
    private String jpushurl = "";
    private String content = "";
    private String title = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jpush_details);
        x.view().inject(this);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        title = intent.getStringExtra("JpushTitle");
        setTitle(title);
        content = intent.getStringExtra("JpushContent");
        jpushurl = intent.getStringExtra("Jpushurl");
        title11.setText("标题：" + title);
        content11.setText("内容：" + content);
        Log.i("ddsd", jpushurl);
        WebSettings ws = webView.getSettings();
        ws.setBuiltInZoomControls(true);// 隐藏缩放按钮
        ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);// 排版适应屏幕
        ws.setUseWideViewPort(true);// 可任意比例缩放
        ws.setLoadWithOverviewMode(true);// setUseWideViewPort方法设置webview推荐使用的窗口。setLoadWithOverviewMode方法是设置webview加载的页面的模式。
        ws.setSavePassword(true);
        ws.setSaveFormData(true);// 保存表单数据
        ws.setJavaScriptEnabled(true);
        ws.setDomStorageEnabled(true);
        webView.setWebViewClient(new xWebChromeClient());

        if (!TextUtils.isEmpty(jpushurl)) {
            webView.loadUrl(jpushurl);

        } else {
            webView.loadUrl("");
            Log.i("kkk", "这是空的");
        }
        Log.i("bibi", title + "@@" + content + "@@" + jpushurl);
    }

    public class xWebChromeClient extends WebViewClient {
        //  跳转到自带浏览器
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }

    //type可选参数, 默认是View.OnClickListener.class
    @Event(value = {R.id.ivTitleBtnLeft}, type = View.OnClickListener.class)
    private void onBtnClick(View v) {
        // 如果是通过消息推送进入，则进入主页
        if (!TextUtils.isEmpty(jpushurl)) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        } else {
            JPushDetailsActivity.this.finish();
        }
    }

    //返回键的监听
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                // 如果是通过消息推送进入，则进入主页
                if (!TextUtils.isEmpty(jpushurl)) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else {
                    JPushDetailsActivity.this.finish();
                }
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }
}
