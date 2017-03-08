package com.example.dk.news_dk1.Response;

import com.example.dk.news_dk1.NewsSourceList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dk on 3/4/2017.
 */
public class NewsSourceResponse {

    @Expose
    @SerializedName("sources")
    public List<NewsSourceList> sources;


}
