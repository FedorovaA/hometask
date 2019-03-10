package com.student.movies.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.student.movies.view.AuthorizationView;

public class AuthorizationPresenter extends BasePresenter<AuthorizationView>{

    private String Login;
    private String Password;

    private static final  String GENERAL="SHOW_MOVIE_ACTIVITY";
    public AuthorizationPresenter(){}

    public void onLogin(String login,String password, Context context){
        Login = "admin";
        Password = "password";
     if (login.equals(Login) && password.equals(Password)){
         view.onLoginSuccess("Wellcome");
         Intent general = new Intent(GENERAL);
         context.startActivity(general);
     }
     else {
         view.onLoginError("Invalid data");
     }
    }

    @Override
    public void onCreate(Bundle saveInstance) {

    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }
}
