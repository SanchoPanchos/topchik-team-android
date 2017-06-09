package com.sasha.reviews.presenters;


import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;
import com.sasha.reviews.contracts.StartContract;
import com.sasha.reviews.model.FirebaseModel;

public class StartPresenter implements StartContract.Presenter, FirebasePresenter {

    private FirebaseModel model;
    private StartContract.View view;

    public StartPresenter(FirebaseModel model, StartContract.View view) {
        this.model = model;
        this.view = view;
        model.setPresenter(this);
    }

    @Override
    public void signInUser(String email, String password, FirebaseAuth mAuth) {
        view.showDialog();
        model.signInUser(email, password, mAuth);
    }

    @Override
    public void onUserSigned() {
        view.hideDialog();
        view.onUserSigned();
    }

    @Override
    public void onSignFailed(String error) {
        view.hideDialog();
        view.onSignFailed(error);
    }

    @Override
    public Activity getActivity() {
        return view.getActivity();
    }
}
