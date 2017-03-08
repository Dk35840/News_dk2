package com.example.dk.news_dk1.Holder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dk.news_dk1.NewsList;
import com.example.dk.news_dk1.R;
import com.ramotion.foldingcell.FoldingCell;
import com.squareup.picasso.Picasso;

/**
 * Created by dk on 2/28/2017.
 */
public class MainHolder extends RecyclerView.ViewHolder {
    TextView main;
    TextView second;
    ImageView imageView;
    Context context;
    NewsList nl;
    ImageButton imageButton;
    String textmessage;
    TextView author;
    TextView urls;

    public MainHolder(View itemView, final Context context) {
        super(itemView);
        this.context = context;
        main = (TextView) itemView.findViewById(R.id.main);
        second = (TextView) itemView.findViewById(R.id.second_main);
        imageView = (ImageView) itemView.findViewById(R.id.imageid);
        author = (TextView) itemView.findViewById(R.id.mainauthor);

        imageButton = (ImageButton) itemView.findViewById(R.id.sendd);

        final FoldingCell fc = (FoldingCell) itemView.findViewById(R.id.folding_cell);

        // attach click listener to folding cell
        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.toggle(false);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textmessage = nl.getUrl();

                Log.d("codekamp", "open page working");

                Uri uri = Uri.parse(textmessage);
                Intent intent = new Intent();
                intent.setData(uri);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

// Verify that the intent will resolve to an activity

            }
        });


    }

    public void bindMovie(NewsList newsList) {
        this.nl = newsList;

        main.setText(nl.getDecr());
        second.setText(nl.getTitle());
        author.setText(nl.getAuthor());
//        urls.setText(nl.getUrl());
        Picasso.with(context).load(nl.getImageUrl())
                .resize(400, 600)
                .centerInside()
                .into(imageView);


    }


}
