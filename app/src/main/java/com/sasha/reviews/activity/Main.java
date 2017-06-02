package com.sasha.reviews.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sasha.reviews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main extends AppCompatActivity {

    @BindView(R.id.teachers)
    Button teachers;
    @BindView(R.id.cources)
    Button cources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        teachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main.this, TeachersActivity.class));
            }
        });
        cources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main.this, CourcesActivity.class));
            }
        });
    }
}
