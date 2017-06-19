package com.sasha.reviews.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sasha.reviews.R;
import com.sasha.reviews.activities.DepartmentInfo;
import com.sasha.reviews.adapters.TeachersAdapter;
import com.sasha.reviews.model.Teacher;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeachersFragment extends Fragment {

    @BindView(R.id.fragment_teachers_list) ListView teachersList;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        Log.i("TAG", "TeachersFragment init");
        ((DepartmentInfo)(getActivity())).getPresenter().loadTeachers(getActivity().getIntent()
                .getExtras().getInt("Department", 0));
    }

    public void onTeachersLoaded(List<Teacher> teachers){
        Log.i("TAG", "Fragment loaded");
        TeachersAdapter adapter = new TeachersAdapter(teachers, getActivity());
        teachersList.setAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teachers, container, false);
        Log.i("TAG", "OnCreateView TEACHERS Fragment");
        ButterKnife.bind(this, view);
        return view;
    }


}
