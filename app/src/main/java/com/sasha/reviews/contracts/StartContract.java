package com.sasha.reviews.contracts;


import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

public interface StartContract {

    interface View{
        void onUserSigned();
        void onSignFailed(String error);
        void showDialog();
        void hideDialog();
        Activity getActivity();
    }

    interface Presenter{
        void signInUser(String email, String password, FirebaseAuth mAuth);
        void onUserSigned();
        void onSignFailed(String error);
        Activity getActivity();
    }
}
