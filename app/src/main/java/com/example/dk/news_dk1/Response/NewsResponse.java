package com.example.dk.news_dk1.Response;

import com.example.dk.news_dk1.NewsList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dk on 2/27/2017.
 */
public class NewsResponse {
    @Expose
    @SerializedName("source")
    public String source;

    @Expose
    @SerializedName("articles")
    public List<NewsList> listMem;
}
