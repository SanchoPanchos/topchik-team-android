package com.sasha.reviews.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sasha.reviews.presenters.FirebasePresenter;
import com.sasha.reviews.presenters.RegisterPresenter;
import com.sasha.reviews.presenters.StartPresenter;

public class FirebaseModel {

    private  FirebasePresenter presenter;
    private DatabaseReference dbRef;

    public void registerUser(final String email, String password, final String name, final int yearStarted, final int yearFinished,
                             FirebaseAuth mAuth){
        Log.i("TAG", "trying register");
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(((RegisterPresenter)presenter).getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            dbRef.child("users").child(FirebaseAuth.getInstance()
                                    .getCurrentUser().getUid()).child("email").setValue(email);
                            dbRef.child("users").child(FirebaseAuth.getInstance()
                                    .getCurrentUser().getUid()).child("name").setValue(name);
                            dbRef.child("users").child(FirebaseAuth.getInstance()
                                    .getCurrentUser().getUid()).child("photo").setValue("");
                            dbRef.child("users").child(FirebaseAuth.getInstance()
                                    .getCurrentUser().getUid()).child("yearOfStudy").setValue(yearStarted);
                            dbRef.child("users").child(FirebaseAuth.getInstance()
                                    .getCurrentUser().getUid()).child("yearOfGraduation").setValue(yearFinished);
                            dbRef.child("users").child(FirebaseAuth.getInstance()
                                    .getCurrentUser().getUid()).child("reviews").setValue("[]");
                            dbRef.child("users").child(FirebaseAuth.getInstance()
                                    .getCurrentUser().getUid()).child("registerDate").setValue("");
                            ((RegisterPresenter)presenter).onUserRegistered();
                        } else {
                            ((RegisterPresenter)presenter).onRegisterFailed(task.getException().getMessage());
                        }
                    }
                });
    }

    public void setPresenter(FirebasePresenter presenter){
        this.presenter = presenter;
    }

    public FirebaseModel() {
        dbRef = FirebaseDatabase.getInstance().getReference();
    }

    public void signInUser(String email, final String password, FirebaseAuth mAuth) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(((StartPresenter)presenter).getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            ((StartPresenter)presenter).onUserSigned();
                        } else {
                            // If sign in fails, display a message to the user.
                            ((StartPresenter)presenter).onSignFailed(task.getException().getMessage());
                        }
                    }
                });
    }
}
