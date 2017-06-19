package com.sasha.reviews.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sasha.reviews.R;
import com.sasha.reviews.model.Department;

import java.util.List;

public class DepartmentsAdapter extends BaseAdapter {

    private List<Department> departments;
    private Activity context;

    public DepartmentsAdapter(List<Department> departments, Activity context) {
        this.departments = departments;
        this.context = context;
    }

    @Override
    public int getCount() {
        return departments.size();
    }

    @Override
    public Object getItem(int i) {
        return departments.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(R.layout.card_departments_list, null, true);
        ((TextView)convertView.findViewById(R.id.card_departments_list_text)).setText(departments.get(position).getName());
        return convertView;
    }
}
