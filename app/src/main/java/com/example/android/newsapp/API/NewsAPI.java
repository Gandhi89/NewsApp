package com.example.android.newsapp.API;

import com.example.android.newsapp.ApiResponseInJava.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsAPI {

    @GET("everything")
    Call<News> getNews(
            @Query("q") String bitcoin,
            @Query("from") String dates,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String APIkey
    );

}
