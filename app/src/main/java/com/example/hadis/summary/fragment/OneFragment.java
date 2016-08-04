package com.example.hadis.summary.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hadis.summary.activity.BarActivity;
import com.example.hadis.summary.activity.CardViewActivity;
import com.example.hadis.summary.R;
import com.example.hadis.summary.activity.BiaoqianActivity;
import com.example.hadis.summary.activity.BlurActivity;
import com.example.hadis.summary.activity.CheckBoxActivity;
import com.example.hadis.summary.activity.CircleProgressActivity;
import com.example.hadis.summary.activity.DrawerActivity;
import com.example.hadis.summary.activity.FrescoActivity;
import com.example.hadis.summary.activity.JavaJSActivity;
import com.example.hadis.summary.activity.MaterialRefreshLayoutActivity;
import com.example.hadis.summary.activity.RecyclerViewActivity;
import com.example.hadis.summary.activity.GlideActivity;
import com.example.hadis.summary.activity.RecorderActivity;
import com.example.hadis.summary.activity.RetrofitActivity;
import com.example.hadis.summary.activity.RxJavaActivity;
import com.example.hadis.summary.activity.RxJavaAndRetrofitActivity;
import com.example.hadis.summary.activity.TestBaiduMapActivity;
import com.example.hadis.summary.activity.UpImageActivity;
import com.example.hadis.summary.base.BaseFragment;
import com.example.hadis.summary.bean.LoLoginResultBean;
import com.example.hadis.summary.bean.LoginResultBean;
import com.example.hadis.summary.utils.GsonUtil;
import com.example.hadis.summary.utils.NetWorkHelper;
import com.example.hadis.summary.utils.ToastUtil;
import com.google.gson.reflect.TypeToken;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * @author hadis on 16.3.10.
 */
public class OneFragment extends BaseFragment {
    @ViewInject(R.id.rec_btn)
    private Button button;
    @ViewInject(R.id.yyyyy)
    private TextView tt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, null);
        x.view().inject(this, view);
        // 第一个参数为模糊半径，越大越模糊。
        // 第二个参数是阴影离开文字的x横向距离。
        // 第三个参数是阴影离开文字的Y横向距离。
        // 第四个参数是阴影颜色。
        tt.setShadowLayer(10F, 5F, 5F, Color.BLACK);
        init(view);
        //initPost();
        return view;
    }

    private void initPost() {
        String url = "www.baidu.com";
        RequestParams params = new RequestParams(url);
        params.addBodyParameter("mm", "meinv");//www.baidu.com?mm=meinv
        params.addParameter("nnn", "wowow");
        params.addQueryStringParameter("que", "hehehhe");
        //params.addHeader("text","love");//无
        //www.baidu.com?que=hehehhe&mm=meinv&nnn=wowow

        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

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

    private void init(final View view) {
        //String url = "http://doctor.ubetween.com.cn/api/medicine/list/pagesize/4/pageno/0/order/zx";
        // String url = "http://account.ubetween.com/mobile/isreg/loginuser/15324316665/type/mobile";
        String url = "http://www.ubetween.com.cn/api/mobile/login/mobile/17888808591/pwd/123456";
        RequestParams params = new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                LoLoginResultBean loLoginResultBean = GsonUtil.GsonToBean(result, LoLoginResultBean.class);
                String status = loLoginResultBean.getStatus();
                Log.i("status", status);
                if (status.equals("1")) {
                    LoLoginResultBean<LoginResultBean.T> loginResultBean = GsonUtil.getGson().fromJson(result, new TypeToken<LoLoginResultBean<LoginResultBean.T>>() {
                    }.getType());
                    String token = loginResultBean.getData().getToken();
                    String id = loginResultBean.getData().getSessionID();
                    ToastUtil.show("登陆成功");
                } else {
                    ToastUtil.show(loLoginResultBean.getMessage());
                }


                //  list.addAll(hahah.getData());
                // String token = list.get(0).getToken();
//                String json = gson.toJson(hahah);//将实体类转为json字符串
//
//                //用法二
//                Type listType = new TypeToken<List<RecycBean.DataBean.Data2Bean>>() {
//                }.getType();
//                String json1 = gson.toJson(list, listType);//从List集合转成json字符串
//                list = gson.fromJson(json1, listType);//从json字符串转成List
//                Log.i("sssss", list + "");
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.i("onError", ex.getMessage());

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    //type可选参数, 默认是View.OnClickListener.class
    @Event(value = {R.id.hhhhsshh, R.id.ccc1, R.id.cardview_btn, R.id.app_btn2, R.id.app_btn, R.id.fresco_btn, R.id.hhhhhh, R.id.material, R.id.rec_btn, R.id.btnss, R.id.slide_btn, R.id.btn_baidu, R.id.up_img, R.id.biaoqian, R.id.checkBox, R.id.maoboli, R.id.rx_android, R.id.img_url, R.id.retrofit_btn}, type = View.OnClickListener.class)
    private void onBtnClick(View v) {
        switch (v.getId()) {
            case R.id.rec_btn:
                startActivity(new Intent(getActivity(), RecyclerViewActivity.class));
                break;
            case R.id.btnss:
                startActivity(new Intent(getActivity(), RecyclerViewActivity.class));
                break;
            case R.id.slide_btn:
                startActivity(new Intent(getActivity(), GlideActivity.class));
                break;
            case R.id.btn_baidu:
                startActivity(new Intent(getActivity(), TestBaiduMapActivity.class));
                break;
            case R.id.up_img:
                startActivity(new Intent(getActivity(), UpImageActivity.class));
                break;
            case R.id.biaoqian:
                startActivity(new Intent(getActivity(), BiaoqianActivity.class));
                break;
            case R.id.checkBox:
                startActivity(new Intent(getActivity(), CheckBoxActivity.class));
                break;
            case R.id.maoboli:
                startActivity(new Intent(getActivity(), BlurActivity.class));
                break;
            case R.id.rx_android:
                startActivity(new Intent(getActivity(), RecorderActivity.class));
                break;
            case R.id.img_url:
                // startActivity(new Intent(getActivity(), GGGGGActivity.class));
                break;
            case R.id.retrofit_btn:
                startActivity(new Intent(getActivity(), RetrofitActivity.class));
                break;
            case R.id.material:
                startActivity(new Intent(getActivity(), MaterialRefreshLayoutActivity.class));
                break;
            case R.id.hhhhhh:
                startActivity(new Intent(getActivity(), JavaJSActivity.class));
                break;
            case R.id.fresco_btn:
                startActivity(new Intent(getActivity(), FrescoActivity.class));
                break;
            case R.id.app_btn:
                startActivity(new Intent(getActivity(), RxJavaActivity.class));
                break;
            case R.id.app_btn2:
                startActivity(new Intent(getActivity(), RxJavaAndRetrofitActivity.class));
                break;
            case R.id.cardview_btn:
                startActivity(new Intent(getActivity(), CardViewActivity.class));
                break;
            case R.id.ccc1:
                startActivity(new Intent(getActivity(), CircleProgressActivity.class));

                break;
            case R.id.hhhhsshh:
                startActivity(new Intent(getActivity(), BarActivity.class));
                break;
        }
    }

    /**
     * 判断网络状态
     */
    private void NetWorkState() {
        boolean is_4G = NetWorkHelper.isMobile_4G(getActivity());//判断网络链接状态
        boolean connected = NetWorkHelper.isConnected(getActivity());//判断网络链接状态
        boolean roaming = NetWorkHelper.isNetworkRoaming(getActivity());//是否为漫游
        boolean mobileDataEnable = NetWorkHelper.isMobileDataEnable(getActivity());//判断MOBILE网络是否可用
        boolean wifiDataEnable = NetWorkHelper.isWifiDataEnable(getActivity());//判断wifi是否可用
        int networkType = NetWorkHelper.getNetworkType(getActivity());//得到当前网络类型
        Log.i("哈哈哈@@##￥￥", "判断网络链接状态：" + connected + "------" + "是否为漫游：" + roaming + "------" + "MOBILE是否可用：" + mobileDataEnable
                + "------" + "wifi是否可用：" + wifiDataEnable + "------" + "当前网络类型是：" + networkType);
        Log.i("是4G吗:", is_4G + "");
    }

}
