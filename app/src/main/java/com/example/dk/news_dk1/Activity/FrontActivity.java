package com.example.dk.news_dk1.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.dk.news_dk1.Adapter.SimpleAdapter;



import com.example.dk.news_dk1.Adapter.FrontAdapter;

import com.example.dk.news_dk1.Client.NewsClient;
import com.example.dk.news_dk1.DatabaseHandler;
import com.example.dk.news_dk1.NewsSourceList;
import com.example.dk.news_dk1.Response.NewsSourceResponse;
import com.example.dk.news_dk1.R;
import com.example.dk.news_dk1.Urls;
import com.example.dk.news_dk1.recycleviewAnumation.DividerItemDecoration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FrontActivity extends AppCompatActivity implements Callback<NewsSourceResponse> {


    RecyclerView myRecyclerView1,recy2;
    public EditText search;

    public List<NewsSourceList> sourceList,s2;

    public Context context;
    public List<String> listTitle;
    SimpleAdapter simpleAdapter2;
    public List<String> listId;
    public List<Urls> urls;
    String[] name=new String[100];
    String[] srt = new String[150];
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        myRecyclerView1= (RecyclerView) findViewById(R.id.frontrecyid);
        search = (EditText) findViewById( R.id.search);
        myRecyclerView1.setHasFixedSize(true);




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

        DatabaseHandler db = new DatabaseHandler(this);

        for(NewsSourceList list:listResponse.sources) {
            Log.d("codeakamp", list.getId());

            srt[i]=new String(list.getId());
            listTitle.add(new String(list.getName()));
            Log.d("codeakamp","the values of srt"+i+srt[i]);

            i++;




            sourceList.add(new NewsSourceList(list.getId(),list.getName(),list.getUrlsToLogos()));
            db.addSource(new NewsSourceList(list.getId(),list.getName(),list.getUrlsToLogos()));


        }



        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView1.setLayoutManager(layoutManager);
        myRecyclerView1.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        myRecyclerView1.setAdapter(new FrontAdapter(this,sourceList));



        addTextListener();
    }



    public void addTextListener(){

        search.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence query, int start, int before, int count) {

                query = query.toString().toLowerCase();

                final List<NewsSourceList> s2 = new ArrayList<>();

                for (int i = 0; i < sourceList.size(); i++) {

                    final String text = sourceList.get(i).getName().toLowerCase();
                    if (text.contains(query)) {

                        s2.add(new NewsSourceList(sourceList.get(i).getName(),sourceList.get(i).getId()));
                    }
                }



                LinearLayoutManager layoutManager2 = new LinearLayoutManager(FrontActivity.this);
                        myRecyclerView1.setLayoutManager(layoutManager2);


                    simpleAdapter2= new SimpleAdapter(FrontActivity.this,s2);
                myRecyclerView1.setAdapter(simpleAdapter2);



                simpleAdapter2.notifyDataSetChanged();  // data set changed
            }
        });
    }

    @Override
    public void onFailure(Call<NewsSourceResponse> call, Throwable t) {

    }


}
