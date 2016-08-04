package com.example.hadis.summary.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hadis.summary.R;
import com.example.hadis.summary.adapter.CardViewAdapter;
import com.example.hadis.summary.adapter.RecyclerViewAdapter;
import com.example.hadis.summary.base.BaseActivity;
import com.example.hadis.summary.bean.Subject;
import com.example.hadis.summary.interfaces.HttpMethods;
import com.example.hadis.summary.interfaces.HttpResult;
import com.example.hadis.summary.utils.GlideUtil;

import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;

public class CardViewActivity extends BaseActivity {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private CardViewAdapter adapter;

    private List<Subject> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        ButterKnife.bind(this);
        callBack();
        setTitle("CardView");
        getRetrofitAndRxJava2();
        initView();
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CardViewAdapter(getApplicationContext(), list);
        recyclerView.setAdapter(adapter);

    }

    private void getRetrofitAndRxJava2() {
        Subscriber<HttpResult<List<Subject>>> subscriber = new Subscriber<HttpResult<List<Subject>>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(HttpResult<List<Subject>> listHttpResult) {
                list.addAll(listHttpResult.getSubjects());
                adapter.notifyDataSetChanged();
            }

        };

        HttpMethods.getInstance().getTopMovieHadis1(subscriber, 1, 10);//封装后的调用
    }

}
