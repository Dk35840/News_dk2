package com.example.dk.news_dk1.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dk.news_dk1.Activity.FrontActivity;
import com.example.dk.news_dk1.Holder.FrontHolder;
import com.example.dk.news_dk1.Holder.MainHolder;
import com.example.dk.news_dk1.NewsList;
import com.example.dk.news_dk1.NewsSourceList;
import com.example.dk.news_dk1.R;

import java.util.List;

/**
 * Created by dk on 3/6/2017.
 */

public class FrontAdapter extends RecyclerView.Adapter<FrontHolder>{

    private Context context;
    private List<NewsSourceList> newsSourceLists;
            private List<String> news;

    public FrontAdapter(Context context, List<NewsSourceList> newsSourceLists) {
        this.context = context;
        this.newsSourceLists = newsSourceLists;
    }


    @Override
    public FrontHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflator=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view=inflator.inflate(R.layout.frontholder,parent,false);

        return new FrontHolder(view,context);
    }

    @Override
    public void onBindViewHolder(FrontHolder holder, int position) {
        NewsSourceList newsList = newsSourceLists.get(position);
        holder.bindMovie(newsList);

    }



    @Override
    public int getItemCount() {
        return newsSourceLists.size();
    }
}
