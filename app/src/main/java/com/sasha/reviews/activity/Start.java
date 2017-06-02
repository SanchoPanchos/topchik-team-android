package com.sasha.reviews.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sasha.reviews.R;
import com.sasha.reviews.contract.StartContract;
import com.sasha.reviews.presenter.StartPresenter;

public class Start extends AppCompatActivity implements StartContract.View {

    StartPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
