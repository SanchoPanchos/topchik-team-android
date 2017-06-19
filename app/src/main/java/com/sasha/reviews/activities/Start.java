package com.sasha.reviews.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.sasha.reviews.R;
import com.sasha.reviews.contracts.StartContract;
import com.sasha.reviews.model.FirebaseModel;
import com.sasha.reviews.presenters.StartPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Start extends AppCompatActivity implements StartContract.View {

    @BindView(R.id.start_email) EditText email;
    @BindView(R.id.start_password) EditText password;
    @BindView(R.id.start_login) Button login;
    @BindView(R.id.start_register) Button register;
    private ProgressDialog dialog;
    private StartPresenter presenter;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        ButterKnife.bind(this);
        presenter = new StartPresenter(new FirebaseModel(), this);
        mAuth = FirebaseAuth.getInstance();
        init();
    }

    private void init() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.signInUser(email.getText().toString(), password.getText().toString(), mAuth);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Start.this, Register.class));
            }
        });
        dialog = new ProgressDialog(Start.this);
        dialog.setTitle("Please wait");
        dialog.setMessage("Signing you in...");
        dialog.setCancelable(false);
    }

    @Override
    public void onUserSigned() {
        startActivity(new Intent(Start.this, Main.class));
    }

    @Override
    public void onSignFailed(String error) {
        Toast.makeText(Start.this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialog() {
        dialog.show();
    }

    @Override
    public void hideDialog() {
        dialog.hide();
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
