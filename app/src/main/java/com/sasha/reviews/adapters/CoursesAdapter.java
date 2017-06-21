package com.sasha.reviews.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sasha.reviews.R;
import com.sasha.reviews.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends BaseAdapter {

   private List<Course> courses;
   private List<View> views;
   private Activity context;

    public CourseAdapter(List<Course> courses, Activity context) {
        this.courses = courses;
        this.context = context;
        this.views = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public Object getItem(int i) {
        return courses.get(i);
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
            convertView = inflater.inflate(R.layout.card_courses_fragment, null, true);
            TextView name = (TextView)convertView.findViewById(R.id.card_courses_fragment_name);
            name.setText(courses.get(position).getName());
            views.add(position, convertView);
        }
        return convertView;
    }
}
