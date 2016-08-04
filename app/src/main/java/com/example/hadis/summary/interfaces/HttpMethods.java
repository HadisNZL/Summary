package com.example.hadis.summary.interfaces;

import com.example.hadis.summary.bean.DataNews;
import com.example.hadis.summary.bean.DataNewsDeatils;
import com.example.hadis.summary.bean.MovieEntity;
import com.example.hadis.summary.bean.Subject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author hadis on 16.7.21.
 */
public class HttpMethods {

    public static final String BASE_URL = "https://api.douban.com/v2/movie/";//豆瓣的


    private static final int DEFAULT_TIMEOUT = 5;//默认超时时间

    private Retrofit retrofit;

    private MovieService1 movieService1;


    private HttpMethods() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        movieService1 = retrofit.create(MovieService1.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    public static HttpMethods getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 用于获取豆瓣电影Top250的数据
     *
     * @param subscriber 由调用者传过来的观察者对象
     * @param start      起始位置
     * @param count      获取长度
     */
    public void getTopMovieHadis(Subscriber<MovieEntity> subscriber, int start, int count) {
        movieService1.getTopMovie(start, count)  //接口里面的方法
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getTopMovieHadis1(Subscriber<HttpResult<List<Subject>>> subscriber, int start, int count) {
        movieService1.getTopMovie1(start, count)   //接口里面的方法
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
