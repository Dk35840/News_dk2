package com.example.dk.news_dk1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dk on 2/28/2017.
 */

public class NewsList {

    @Expose
    @SerializedName("author")
    private String author;

    @Expose
    @SerializedName("urlToImage")
    private String imageUrl;

    public NewsList(String title, String decr ,String imageUrl, String author, String url) {
        this.title=title;
        this.decr=decr;
        this.imageUrl=imageUrl;
        this.url=url;
        this.author=author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getAuthor() {
        
        
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDecr() {
        return decr;
    }

    public String getUrl() {
        return url;
    }

    @Expose
    @SerializedName("title")
    private String title;

     @Expose
    @SerializedName("description")
    private String decr;





    @Expose
    @SerializedName("url")
    private String url;

}
