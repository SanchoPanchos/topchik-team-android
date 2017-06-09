package com.sasha.reviews.presenters;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;
import com.sasha.reviews.contracts.RegisterContract;
import com.sasha.reviews.model.FirebaseModel;

public class RegisterPresenter implements RegisterContract.Presenter, FirebasePresenter{

    RegisterContract.View view;
    FirebaseModel model;

    public RegisterPresenter(RegisterContract.View view, FirebaseModel model) {
        this.view = view;
        this.model = model;
        model.setPresenter(this);
    }

    @Override
    public void registerUser(String email, String password, String name, int yearStarted, int yearFinished,
                             FirebaseAuth mAuth) {
        view.showDialog();
        model.registerUser(email, password, name, yearStarted, yearFinished, mAuth);
    }

    @Override
    public void onUserRegistered() {
        view.hideDialog();
        view.onUserRegistered();
    }

    @Override
    public void onRegisterFailed(String error) {
        view.hideDialog();
        view.onRegisterFailed(error);
    }

    @Override
    public Activity getActivity() {
        return view.getActivity();
    }
}
