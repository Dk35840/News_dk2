package com.example.dk.news_dk1.Holder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dk.news_dk1.Activity.BackActivity;
import com.example.dk.news_dk1.Activity.FrontActivity;
import com.example.dk.news_dk1.NewsSourceList;
import com.example.dk.news_dk1.R;
import com.squareup.picasso.Picasso;

/**
 * Created by dk on 3/6/2017.
 */
public class FrontHolder extends RecyclerView.ViewHolder {

    TextView textView;
    ImageView imgview;
    Context context;
    String id;
    NewsSourceList nsl;
    public FrontHolder(View itemView, final Context context) {
        super(itemView);
        this.context = context;

        textView= (TextView) itemView.findViewById(R.id.textmy);
        imgview= (ImageView) itemView.findViewById(R.id.img);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(FrontHolder.this.context,BackActivity.class);
                id=nsl.getId();
                intent.putExtra("position",id);
                context.startActivity(intent);
            }

        }
        );
    }



    public void bindMovie(NewsSourceList newsSourceList) {

        this.nsl=newsSourceList;
        textView.setText(nsl.getName());
        Picasso.with(context).load(nsl.getUrlsToLogos().getSmallimg())
                .into(imgview);
    }
}
