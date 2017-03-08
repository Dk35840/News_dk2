package com.example.dk.news_dk1.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.dk.news_dk1.recycleviewAnumation.DividerItemDecoration;
import com.example.dk.news_dk1.Adapter.FoldingCellListAdapter;
import com.example.dk.news_dk1.Client.NewsClient;
import com.example.dk.news_dk1.NewsList;
import com.example.dk.news_dk1.Response.NewsResponse;
import com.example.dk.news_dk1.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BackActivity extends AppCompatActivity implements Callback<NewsResponse> {
        RecyclerView myRecyclerView;
    public List<String> listTitle;
  public List<String> listDescription;
    public List<String> imgUrl;
    public List<NewsList> nl;
    String textmessage;

    @Override
    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {

        NewsResponse listResponse = response.body();



        Log.d("codekamp", "news source: " + listResponse.source);

        listTitle =new ArrayList<>();
        listDescription=new ArrayList<>();
        nl=new ArrayList<>();
        for(NewsList list:listResponse.listMem) {
            Log.d("codeakamp", list.getTitle());

            Log.d("codeakamp","the values of srt");
            listTitle.add(new String(list.getTitle()));
            listDescription.add(new String(list.getDecr()));
            nl.add(new NewsList(list.getTitle(),list.getDecr(),list.getImageUrl(),list.getAuthor(),list.getUrl()));
        }


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        myRecyclerView.setAdapter(new FoldingCellListAdapter(this,nl));

    }

    @Override
    public void onFailure(Call<NewsResponse> call, Throwable t) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView)findViewById(R.id.my_recyid);




        Intent intent= getIntent();
        String str= intent.getStringExtra("position");

        Log.d("codekamp","got key"+str);




        Call<NewsResponse> call = NewsClient.getClient().fetchArticle("07d1d35e80cb4e31a4b7e0b86c9787ce",str);

        call.enqueue(this);

        // get our folding cell

    }
}
