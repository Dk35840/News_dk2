package com.example.dk.news_dk1.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dk.news_dk1.Holder.MainHolder;
import com.example.dk.news_dk1.NewsList;
import com.example.dk.news_dk1.R;

import java.util.List;

/**
 * Created by dk on 2/28/2017.
 */
public class FoldingCellListAdapter extends RecyclerView.Adapter<MainHolder>{
    private Context context;
    private List<NewsList> newsLists;

    public FoldingCellListAdapter(Context context, List<NewsList> newsLists) {
        this.context = context;
        this.newsLists=newsLists;
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflator=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view=inflator.inflate(R.layout.foldingcell,parent,false);

        return new MainHolder(view,context);
    }

    @Override
    public void onBindViewHolder(MainHolder holder, int position) {
        NewsList newsList = newsLists.get(position);
        holder.bindMovie(newsList);
    }

    @Override
    public int getItemCount() {
        return newsLists.size();
    }



}
