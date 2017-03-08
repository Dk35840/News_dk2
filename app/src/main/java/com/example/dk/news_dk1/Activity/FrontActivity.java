package com.example.dk.news_dk1.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.dk.news_dk1.Adapter.FrontAdapter;
import com.example.dk.news_dk1.Client.NewsClient;
import com.example.dk.news_dk1.NewsSourceList;
import com.example.dk.news_dk1.Response.NewsSourceResponse;
import com.example.dk.news_dk1.R;
import com.example.dk.news_dk1.Urls;
import com.example.dk.news_dk1.recycleviewAnumation.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FrontActivity extends AppCompatActivity implements Callback<NewsSourceResponse> {

    RecyclerView myRecyclerView1;

    public List<NewsSourceList> sourceList;
    public Context context;
    public List<String> listTitle;
    public List<String> listId;
    public List<Urls> urls;
    String[] srt = new String[150];
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        myRecyclerView1= (RecyclerView) findViewById(R.id.frontrecyid);


        Call<NewsSourceResponse> call = NewsClient.getClient().fetchSource("en");

        call.enqueue(this);
    }



    @Override
    public void onResponse(Call<NewsSourceResponse> call, Response<NewsSourceResponse> response) {
        NewsSourceResponse listResponse = response.body();



        Log.d("codekamp", "news response called");
        listTitle=new ArrayList<>();
        listId=new ArrayList<>();
        sourceList=new ArrayList<>();
        urls=new ArrayList<>();
        i=0;

        for(NewsSourceList list:listResponse.sources) {
            Log.d("codeakamp", list.getId());
            srt[i]=new String(list.getId());
            Log.d("codeakamp","the values of srt"+i+srt[i]);

            i++;




            sourceList.add(new NewsSourceList(list.getId(),list.getName(),list.getUrlsToLogos()));

        }



        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView1.setLayoutManager(layoutManager);
        myRecyclerView1.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        myRecyclerView1.setAdapter(new FrontAdapter(this,sourceList));

    }

    @Override
    public void onFailure(Call<NewsSourceResponse> call, Throwable t) {

    }


}
