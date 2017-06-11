package com.sasha.reviews.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sasha.reviews.R;

public class TeachersSmallViewHolder extends RecyclerView.ViewHolder{

    public ImageView image;
    public TextView text;


    public TeachersSmallViewHolder(View itemView) {
        super(itemView);
        image = (ImageView)itemView.findViewById(R.id.card_teacher_small_image);
        text = (TextView) itemView.findViewById(R.id.card_teacher_small_text);
    }
}
