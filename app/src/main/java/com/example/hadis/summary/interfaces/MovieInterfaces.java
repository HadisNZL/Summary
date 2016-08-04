package com.example.hadis.summary.interfaces;

import com.example.hadis.summary.bean.MovieEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author hadis on 16.7.18.
 */
public class MovieInterfaces {

    public interface MovieService {
        @GET("top250")
        Call<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);
    }
}
