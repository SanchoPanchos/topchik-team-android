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

public class TeachersAdapter extends RecyclerView.Adapter<TeachersViewHolder> {

    private Activity context;
    private List<Teacher> teachers;

    public TeachersAdapter(Activity context, List<Teacher> teachers) {
        this.context = context;
        this.teachers = teachers;
    }

    @Override
    public TeachersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_teacher_small, parent, false);
        return new TeachersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TeachersViewHolder holder, int position) {
        if(position==teachers.size()){
            holder.image.setBackgroundColor(Color.BLACK);
            holder.text.setText("END");
        }
        else{
            Glide.with(context).load(teachers.get(position).getImage())
                    .into(holder.image);
            holder.text.setText(teachers.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return teachers.size()+1;
    }
}
