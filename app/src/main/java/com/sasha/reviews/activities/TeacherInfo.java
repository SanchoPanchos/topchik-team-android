package com.sasha.reviews.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Spinner;

import com.sasha.reviews.R;
import com.sasha.reviews.adapters.TeachersSmallAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeachersActivity extends AppCompatActivity {

    @BindView(R.id.teachers_list) ListView teachersList;
    @BindView(R.id.teachers_spinner) Spinner teachersSpinner;
    TeachersSmallAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teachers);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        //adapter = new TeachersSmallAdapter(this, );
        //teachersList.setAdapter(adapter);
    }
}
