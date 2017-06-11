package com.sasha.reviews.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sasha.reviews.R;


public class FacultiesViewHolder extends RecyclerView.ViewHolder {

    public ImageView image;
    public TextView text;

    public FacultiesViewHolder(View itemView) {
        super(itemView);
        image = (ImageView)itemView.findViewById(R.id.card_faculty_image);
        text = (TextView) itemView.findViewById(R.id.card_faculty_text);
    }
}