package com.example.newz;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    private final TextView txtTitle;
    private final TextView txtSourceName;
    private final TextView txtDate;
    public TextView txt_description;
    private final ImageView imgThumbnail;
    private boolean isExpanded;


    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        this.txtTitle = itemView.findViewById(R.id.txt_title);
        this.txtSourceName = itemView.findViewById(R.id.txt_source_name);
        this.txtDate = itemView.findViewById(R.id.txt_date);
        this.imgThumbnail = itemView.findViewById(R.id.img_thumbnail);
        this.txt_description=itemView.findViewById(R.id.txt_description);
        isExpanded = false;


    }


    public void setTxt_description(TextView txt_description) {
        this.txt_description = txt_description;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
    public void setTxtTitle(String txtTitle) {
        this.txtTitle.setText(txtTitle);
    }

    public void setTxtSourceName(String txtSourceName) {
        this.txtSourceName.setText(txtSourceName);
    }

    public void setTxtDate(String txtDate) {
        this.txtDate.setText(txtDate);
    }

    public void setImgThumbnail(Context context , String url) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .apply(new RequestOptions().override(100,100))
                .into(this.imgThumbnail);
    }


}
