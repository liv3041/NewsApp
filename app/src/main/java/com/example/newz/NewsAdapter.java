package com.example.newz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    private Context context;
    private List<Article> articleList;


    public NewsAdapter(Context context, List<Article> articleList) {
        this.context = context;
        this.articleList = articleList;

    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_news,parent,false);
        return new NewsViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, @SuppressLint("RecyclerView") int position) {
      Article article = articleList.get(position);
      holder.setTxtSourceName(article.getSource().getName());
      holder.setTxtTitle(article.getTitle());
      holder.setTxtDate(article.getPublishedAt());
      holder.setImgThumbnail(context,article.getUrlToImage());
      boolean isExpanded = holder.isExpanded();
       CardView cardViewE = holder.itemView.findViewById(R.id.cardViewE);
       LinearLayout collapsedLayout = holder.itemView.findViewById(R.id.collapsedLayout);
        LinearLayout expandedLayout = holder.itemView.findViewById(R.id.expandedLayout);
        CardView cardView = holder.itemView.findViewById(R.id.cardView);
        TextView txtDescription = holder.itemView.findViewById(R.id.txt_description);
        ImageView ImgThumbnail = holder.itemView.findViewById(R.id.img_thumbnailE);
        TextView title = holder.itemView.findViewById(R.id.txt_titleE);
        TextView date = holder.itemView.findViewById(R.id.txt_dateE);
        TextView source = holder.itemView.findViewById(R.id.txt_source_nameE);
        txtDescription.setText(article.getDescription());
        title.setText(article.getTitle());
        date.setText(article.getSource().getName());
        Glide.with(context)
                    .load(article.getUrlToImage())
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .apply(new RequestOptions().override(200,200))
                    .into(ImgThumbnail);

        boolean newExpandedState = !isExpanded;
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                holder.setExpanded(newExpandedState);
                expandedLayout.setVisibility(newExpandedState ? View.VISIBLE : View.GONE);
            }
        });
        cardViewE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                expandedLayout.setVisibility(newExpandedState?View.GONE:View.VISIBLE);


            }
        });
    }

    @Override
    public int getItemCount() {
        return articleList==null?0:articleList.size();
    }





}
