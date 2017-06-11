package com.sasha.reviews.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.sasha.reviews.R;
import com.sasha.reviews.model.Teacher;

import java.util.List;

public class TeachersSmallAdapter extends RecyclerView.Adapter<TeachersSmallViewHolder> {

    private Activity context;
    private List<Teacher> teachers;

    public TeachersSmallAdapter(Activity context, List<Teacher> teachers) {
        this.context = context;
        this.teachers = teachers;
    }

    @Override
    public TeachersSmallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_teacher_small, parent, false);
        return new TeachersSmallViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TeachersSmallViewHolder holder, int position) {
        if(position == teachers.size()){
            holder.image.setBackgroundColor(Color.BLACK);
            holder.image.setImageResource(R.drawable.ic_more_vert_white_24dp);
            holder.text.setText("Більше");
        }
        else{
            Glide.with(context).load(teachers.get(position).getImage())
                    .into(holder.image);
            holder.text.setText(teachers.get(position).getNameShort());
        }
    }

    @Override
    public int getItemCount() {
        return teachers.size()+1;
    }
}
