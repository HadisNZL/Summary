package com.example.hadis.summary.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hadis.summary.R;
import com.example.hadis.summary.fragment.FourFragment;
import com.example.hadis.summary.fragment.LeftFragment;
import com.example.hadis.summary.fragment.OneFragment;
import com.example.hadis.summary.fragment.RightFragment;
import com.example.hadis.summary.fragment.ThreeFragment;
import com.example.hadis.summary.slidingmenu.BaseSlidingFragmentActivity;
import com.example.hadis.summary.slidingmenu.SlidingMenu;

import org.xutils.view.annotation.Event;
import org.xutils.x;

/**
 * @author hadis on 16.4.15.
 */
public class MainSMActivity extends BaseSlidingFragmentActivity {
    protected SlidingMenu mSlidingMenu;
    private Fragment mContent;
    private long oneTime = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //悬浮
//        WindowManager wm = (WindowManager) getApplicationContext()
//                .getSystemService(WINDOW_SERVICE);
//        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
//        // 悬浮所有页面之上
//        lp.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
//        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
//        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        // 失去焦点
//        lp.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
//                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
//        TextView tv = new TextView(this);
//        tv.setText("我是不是你最疼爱的人，你为什么不说话，握住是你冰冷的手动也不动让我好难过");
//        tv.setBackgroundColor(Color.WHITE);
//        wm.addView(tv, lp);

        if (savedInstanceState != null) { // 如果保存的状态不为空则得到之前保存的Fragment，否则实例化MyFragment
            mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
        }
        if (mContent == null) {
            mContent = new OneFragment();
        }
        initLeftgMenu();//左侧菜单
        setContentView(R.layout.activity_main_sm);
        x.view().inject(this);
        getReplaceFragment(R.id.content_frame, new OneFragment());//主Fragment
        mSlidingMenu.setSecondaryMenu(R.layout.fragment_right);//右侧菜单
        getReplaceFragment(R.id.main_right_fragment, new RightFragment());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 31) {
            showToast("跳转过去");
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("nnee", "zou onNewIntent");
    }

    private void initLeftgMenu() {
        setBehindContentView(R.layout.fragment_left);// 设置左菜单
        getReplaceFragment(R.id.main_right_fragment, new LeftFragment());
        mSlidingMenu = getSlidingMenu();
        mSlidingMenu.setMode(SlidingMenu.LEFT_RIGHT);// 设置是左滑还是右滑，还是左右都可以滑，我这里左右都可以滑
        mSlidingMenu.setShadowWidth(getScreenWidth() / 60);// 设置阴影宽度
        mSlidingMenu.setBehindOffset(getScreenWidth() / 8);// 设置菜单宽度
        mSlidingMenu.setBehindWidth((int) (getScreenWidth() * 0.65));// 动态设置左边菜单伸出宽度
        mSlidingMenu.setRightBehindWidth((int) (getScreenWidth() * 0.85));// 动态设置右边菜单伸出宽度
        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        mSlidingMenu.setShadowDrawable(R.drawable.slidingmenu_shadow);// 设置左菜单阴影图片
        mSlidingMenu.setSecondaryShadowDrawable(R.drawable.right_shadow);// 设置右菜单阴影图片
        mSlidingMenu.setFadeEnabled(true);// 设置滑动时菜单的是否淡入淡出
        mSlidingMenu.setFadeDegree(0.0f);// 设置淡入淡出的比例(范围0.0~1.0f)
        mSlidingMenu.setBehindScrollScale(0.333f);// 设置滑动时拖拽效果
    }

    /**
     * replace替换
     *
     * @param resId
     * @param fragment
     */
    private void getReplaceFragment(int resId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(resId, fragment);
        fragmentTransaction.commit();
    }

    /**
     * 获取屏幕分辨率宽度
     */
    private int getScreenWidth() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int mScreenWidth = dm.widthPixels;// 获取屏幕分辨率宽度
        return mScreenWidth;
    }

    /**
     * 切换Fragment
     *
     * @param fragment
     * @param title
     */
    public void switchConent(Fragment fragment, String title) {
        mContent = fragment;
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
        getSlidingMenu().showContent();
    }

    @Event({R.id.ivTitleBtnLeft, R.id.ivTitleBtnRigh, R.id.ivTitleName})
    private void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.ivTitleBtnLeft:
                mSlidingMenu.showMenu(true);
                break;
            case R.id.ivTitleBtnRigh:
                mSlidingMenu.showSecondaryMenu(true);
                break;
            case R.id.ivTitleName:
                startActivityForResult(new Intent(MainSMActivity.this, GGGGGActivity.class), 31);
                break;
        }
    }


}
