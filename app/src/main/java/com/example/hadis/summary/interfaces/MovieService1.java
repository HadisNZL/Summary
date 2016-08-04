package com.example.hadis.summary.interfaces;

import com.example.hadis.summary.bean.DataNews;
import com.example.hadis.summary.bean.DataNewsDeatils;
import com.example.hadis.summary.bean.MovieEntity;
import com.example.hadis.summary.bean.Subject;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author hadis on 16.7.19.
 */
public interface MovieService1 {

    // https://api.douban.com/v2/movie/top250?start=0&count=10

    @GET("top250")
    Observable<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);

    @GET("top250")
    Observable<HttpResult<List<Subject>>> getTopMovie1(@Query("start") int start, @Query("count") int count);

    // http://family.ubetween.com/api/homepage/news/pagesize/3/pageno/0

}
