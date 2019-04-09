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
import com.student.movies.presenter.AuthorizationPresenter;
import com.student.movies.view.AuthorizationView;

public class AuthorizationActivity extends AppCompatActivity implements AuthorizationView {

    EditText edtLogin;
    EditText edtPassword;
    Button btnLogin;
    AuthorizationPresenter authorizationPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        edtLogin = findViewById(R.id.edt_login);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        authorizationPresenter = new AuthorizationPresenter();
        authorizationPresenter.setView(this);
        if(authorizationPresenter.isAuth()){
            onMovies();
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authorizationPresenter.onLogin(edtLogin.getText().toString(),edtPassword.getText().toString(),getContext());
            }
        });


    }

    @Override
    public void onLoginSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMovies() {
        Intent general = new Intent(getContext(),MovieListActivity.class);
        general.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(general);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showToast(String message) {

    }
}
