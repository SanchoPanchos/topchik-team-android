package com.sasha.reviews.contracts;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

public interface RegisterContract {

    interface View{
        void onUserRegistered();
        void onRegisterFailed(String error);
        Activity getActivity();
        void showDialog();
        void hideDialog();
    }

    interface Presenter{
        void registerUser(String email, String password, String name, int yearStarted, int yearFinished,
                          FirebaseAuth mAuth);
        void onUserRegistered();
        void onRegisterFailed(String error);
        Activity getActivity();
    }
}
