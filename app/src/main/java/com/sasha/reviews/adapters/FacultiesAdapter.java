package com.sasha.reviews.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.sasha.reviews.R;
import com.sasha.reviews.model.Faculty;

import java.util.List;

public class FacultiesAdapter extends RecyclerView.Adapter<FacultiesViewHolder> {

    private Activity context;
    private List<Faculty> faculties;

    public FacultiesAdapter(Activity context, List<Faculty> faculties) {
        this.context = context;
        this.faculties = faculties;
    }

    @Override
    public FacultiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_faculty, parent, false);
        return new FacultiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FacultiesViewHolder holder, int position) {
        holder.text.setText(faculties.get(position).getNameShort());
        Glide.with(context).load(faculties.get(position).getImg()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return faculties.size();
    }
}
