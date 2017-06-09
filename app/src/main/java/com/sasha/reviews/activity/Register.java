package com.sasha.reviews.activity;

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
import com.sasha.reviews.contracts.RegisterContract;
import com.sasha.reviews.model.FirebaseModel;
import com.sasha.reviews.presenters.RegisterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Register extends AppCompatActivity implements RegisterContract.View{

    @BindView(R.id.register_name) EditText name;
    @BindView(R.id.register_email) EditText email;
    @BindView(R.id.register_password) EditText password;
    @BindView(R.id.register_year_begin) EditText yearBegin;
    @BindView(R.id.register_year_end) EditText yearEnd;

    @BindView(R.id.register_register) Button register;
    @BindView(R.id.register_login) Button login;

    ProgressDialog dialog;
    private FirebaseAuth mAuth;
    RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        presenter = new RegisterPresenter(this, new FirebaseModel());
        init();
    }

    private void init() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, Start.class));
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fieldsOK()){
                    presenter.registerUser(email.getText().toString(), password.getText().toString(),
                            name.getText().toString(), Integer.parseInt(yearBegin.getText().toString()),
                            Integer.parseInt(yearEnd.getText().toString()), mAuth);
                }
            }
        });
        dialog = new ProgressDialog(Register.this);
        dialog.setTitle("Please wait");
        dialog.setMessage("Registering you in system...");
        dialog.setCancelable(false);

        mAuth = FirebaseAuth.getInstance();
    }

    private boolean fieldsOK() {
       if(name.getText().toString().isEmpty()) {
           Toast.makeText(Register.this, "Name must not be empty", Toast.LENGTH_SHORT).show();
           return false;
       }
        if(name.getText().toString().isEmpty()) {
            Toast.makeText(Register.this, "Name must not be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(name.getText().toString().isEmpty()) {
            Toast.makeText(Register.this, "Name must not be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(name.getText().toString().isEmpty()) {
            Toast.makeText(Register.this, "Name must not be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(name.getText().toString().isEmpty()) {
            Toast.makeText(Register.this, "Name must not be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onUserRegistered() {
        startActivity(new Intent(Register.this, Main.class));
    }

    @Override
    public void onRegisterFailed(String error) {
        Toast.makeText(Register.this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void showDialog() {
        dialog.show();
    }

    @Override
    public void hideDialog() {
        dialog.hide();
    }
}
