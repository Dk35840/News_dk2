package com.example.dk.news_dk1.Client;

import com.example.dk.news_dk1.NewsApi.Newsapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dk on 2/28/2017.
 */

public class NewsClient {
    private static final String Base_URL="https://newsapi.org/v1/";

    public static Newsapi getClient(){
        Retrofit retrofit= new Retrofit.Builder().baseUrl(Base_URL).addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit.create(Newsapi.class);
    }
}
