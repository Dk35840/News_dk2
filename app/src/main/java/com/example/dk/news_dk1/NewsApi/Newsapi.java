package com.example.dk.news_dk1.NewsApi;

import com.example.dk.news_dk1.Response.NewsResponse;
import com.example.dk.news_dk1.Response.NewsSourceResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dk on 2/28/2017.
 */

public interface Newsapi {

    @GET("articles")
    public Call<NewsResponse> fetchArticle(@Query("apiKey") String apiKey, @Query("source") String sources) ;
    @GET("sources")
    public Call<NewsSourceResponse> fetchSource(@Query("language") String countryCode);
}
