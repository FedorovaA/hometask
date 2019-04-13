package com.student.movies.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.student.movies.R;
import com.student.movies.presenter.AuthorizationActivityPresenter;
import com.student.movies.view.AuthorizationActivityView;

import khangtran.preferenceshelper.PrefHelper;

public class AuthorizationActivity extends AppCompatActivity implements AuthorizationActivityView {

    EditText edtLogin;
    EditText edtPassword;
    Button btnLogin;
    Button btnRegister;
    AuthorizationActivityPresenter authorizationActivityPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        edtLogin = findViewById(R.id.edt_login);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        authorizationActivityPresenter = new AuthorizationActivityPresenter();
        authorizationActivityPresenter.setView(this);
        if(authorizationActivityPresenter.isAuth()){
            onMovies();
        }

        btnRegister.setOnClickListener(v->{
            Intent intent = new Intent(getContext(),RegisterActivity.class);
            startActivity(intent);
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrefHelper.removeAllKeys();
                authorizationActivityPresenter.onLogin(edtLogin.getText().toString(),edtPassword.getText().toString(),getContext());
            }
        });


    }

    @Override
    public void onLoginSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMovies() {
        Intent general = new Intent(getContext(),MovieListActivity.class);
        startActivity(general);
        finish();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showToast(String message) {

    }
}
