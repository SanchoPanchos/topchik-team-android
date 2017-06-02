package com.sasha.reviews.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.sasha.reviews.model.Teacher;

import java.util.List;

public class TeachersAdapter extends BaseAdapter {

    private List<Teacher> teachers;
    private List<View> views;

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
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
