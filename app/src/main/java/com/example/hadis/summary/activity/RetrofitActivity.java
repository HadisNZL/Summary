package com.example.hadis.summary.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hadis.summary.R;
import com.example.hadis.summary.base.BaseActivity;
import com.example.hadis.summary.bean.DataNews;
import com.example.hadis.summary.bean.DataNewsDeatils;
import com.example.hadis.summary.bean.MovieEntity;
import com.example.hadis.summary.bean.Subject;
import com.example.hadis.summary.interfaces.HttpMethods;
import com.example.hadis.summary.interfaces.HttpNewsResult;
import com.example.hadis.summary.interfaces.HttpResult;
import com.example.hadis.summary.interfaces.MovieInterfaces;
import com.example.hadis.summary.interfaces.MovieService1;
import com.example.hadis.summary.utils.GlideUtil;


import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RetrofitActivity extends BaseActivity {

    private ProgressDialog dialog;
    private int page = 1;

    @Bind(R.id.btn_click)
    Button btn_click;

    @Bind(R.id.img_pic)
    ImageView imageView;

    @Bind(R.id.test_tv)
    TextView test_tv;

    private List<Subject> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
        String ddUrl1 = "https://api.douban.com/v2/movie/top250?start=0&count=10";
    }

    @OnClick(R.id.btn_click)
    public void onClick(View view) {
        if (view.getId() == R.id.btn_click) {
            // getRetrofit();//原生的Retrofit
            // getRetrofitAndRxJava();//未封装的
//            getRetrofitAndRxJava1();//封装的
            java.util.Random random = new java.util.Random();// 定义随机类
            page = random.nextInt(10);// 返回[0,10)集合中的整数，注意不包括10
            getRetrofitAndRxJava2();//封装的带有泛型的
        }

    }

    /**
     * 原生的Retrofit  对比看MovieService和MovieService1 和请求方法
     */
    private void getRetrofit() {
        String baseUrl = "https://api.douban.com/v2/movie/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieInterfaces.MovieService movieService = retrofit.create(MovieInterfaces.MovieService.class);
        Call<MovieEntity> topMovie = movieService.getTopMovie(0, 10);

        topMovie.enqueue(new Callback<MovieEntity>() {

            @Override
            public void onResponse(Call<MovieEntity> call, Response<MovieEntity> response) {
                MovieEntity body = response.body();
                String titleTv = body.getTitle();
                showToast(titleTv);
                Log.i("bodyii", titleTv + "------");

            }

            @Override
            public void onFailure(Call<MovieEntity> call, Throwable t) {

            }
        });
    }

    /**
     * Retrofit 和RxJava结合  对比看MovieService和MovieService1 和请求方法
     */
    private void getRetrofitAndRxJava() {
        String baseUrl = "https://api.douban.com/v2/movie/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        MovieService1 movieService = retrofit.create(MovieService1.class);

        movieService.getTopMovie(0, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieEntity>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(RetrofitActivity.this, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(MovieEntity movieEntity) {
                        showToast(movieEntity.toString());
                    }
                });
    }


    private void getRetrofitAndRxJava1() {
        Subscriber<MovieEntity> subscriber = new Subscriber<MovieEntity>() {
            @Override
            public void onCompleted() {
                showToast("完成");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MovieEntity movieEntity) {
                test_tv.setText(movieEntity.getTitle());
            }
        };
        HttpMethods.getInstance().getTopMovieHadis(subscriber, 0, 10);//封装后的调用
    }


    private void getRetrofitAndRxJava2() {
        //      dialog = ProgressDialog.show(this, null, "正在加载...", true, true);
        Subscriber<HttpResult<List<Subject>>> subscriber = new Subscriber<HttpResult<List<Subject>>>() {
            @Override
            public void onCompleted() {
                showToast("完成" + page);
                //  dialog.dismiss();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(HttpResult<List<Subject>> listHttpResult) {
                //  test_tv.setText(listHttpResult.getSubjects().get(0).getTitle());
                list.addAll(listHttpResult.getSubjects());
                listHttpResult.getCount();
                test_tv.setText("第" + page + "页: " + listHttpResult.getSubjects().get(0).getTitle());
                GlideUtil.loadImgCenterCrop(getApplicationContext(), listHttpResult.getSubjects().get(0).getImages().getLarge(), R.color.white, imageView);
            }

        };

        HttpMethods.getInstance().getTopMovieHadis1(subscriber, page, 10);//封装后的调用
    }


}
