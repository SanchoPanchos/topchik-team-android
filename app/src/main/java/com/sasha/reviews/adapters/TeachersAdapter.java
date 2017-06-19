package com.sasha.reviews.adapters;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sasha.reviews.R;
import com.sasha.reviews.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeachersAdapter extends BaseAdapter{

    private List<Teacher> teachers;
    private Activity context;
    private List<View> views = new ArrayList<>();

    public TeachersAdapter(List<Teacher> teachers, Activity context) {
        this.teachers = teachers;
        this.context = context;
    }

    @Override
    public int getCount() {
        return teachers.size();
    }

    @Override
    public Object getItem(int i) {
        return teachers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
       try{
           return views.get(position);
       }catch (IndexOutOfBoundsException e){
           LayoutInflater inflater = context.getLayoutInflater();
           convertView = inflater.inflate(R.layout.card_teachers_fragment, null, true);
           ImageView image = (ImageView)convertView.findViewById(R.id.card_teachers_fragment_image);
           Glide.with(context).load(teachers.get(position).getImage()).into(image);
           TextView name = (TextView)convertView.findViewById(R.id.card_teachers_fragment_name);
           name.setText(teachers.get(position).getName());
           views.add(position, convertView);
       }
       return convertView;
    }
}
