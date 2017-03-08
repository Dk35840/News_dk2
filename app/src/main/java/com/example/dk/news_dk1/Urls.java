package com.example.dk.news_dk1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dk on 3/6/2017.
 */
public class  Urls {

    @Expose
    @SerializedName("small")
    private String smallimg;

    @Expose
    @SerializedName("medium")
    private String mediumimg;

    public String getSmallimg() {
        return smallimg;
    }

    public Urls(String smallimg) {
        this.smallimg = smallimg;
    }

    public String getMediumimg() {
        return mediumimg;
    }
}
