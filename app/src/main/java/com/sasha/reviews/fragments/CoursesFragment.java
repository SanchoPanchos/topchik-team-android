package com.sasha.reviews.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sasha.reviews.R;

import butterknife.ButterKnife;

public class CoursesFragment extends Fragment{

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("TAG", "Actiity");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_courses, container, false);
        Log.i("TAG", "OnCreateView Courses Fragment");
        ButterKnife.bind(this, view);
        return view;
    }
}
