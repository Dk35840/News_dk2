package com.example.dk.news_dk1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dk on 3/4/2017.
 */

public class NewsSourceList {
    @Expose
    @SerializedName("id")
    private String id;



    public NewsSourceList(String name, String id) {

        this.name = name;
        this.id = id;
    }

    public NewsSourceList(String id, String name, Urls urlsToLogos) {
        this.id = id;
        this.name = name;
        this.urlsToLogos=urlsToLogos;
    }
    public NewsSourceList(String id, String name, String urlsToLogos) {
        this.id = id;
        this.name = name;
        this.url=urlsToLogos;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Urls getUrlsToLogos() {
        return urlsToLogos;
    }

    public String getUrl() {
        return url;
    }

    @Expose
    @SerializedName("name")

    private String name;





    @Expose
    @SerializedName("url")
    private String url;

        @Expose
    @SerializedName("urlsToLogos")
    private Urls urlsToLogos;


}
