package com.sasha.reviews.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sasha.reviews.R;
import com.sasha.reviews.contract.MainContract;
import com.sasha.reviews.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
