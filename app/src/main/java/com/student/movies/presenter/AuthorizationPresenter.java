package com.student.movies.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.student.movies.view.AuthorizationView;

import khangtran.preferenceshelper.PrefHelper;

public class AuthorizationPresenter extends BasePresenter<AuthorizationView>{

    private String Password;

    public AuthorizationPresenter(){}

    public void onLogin(String login,String password, Context context){
        Password = "qpwoei";
        if(!login.isEmpty() && !password.isEmpty())
        {
            if (password.equals(Password)){
         view.onLoginSuccess("Wellcome");
         view.onMovies();
                PrefHelper.setVal("Auth",true);
     }
     else {
                view.onLoginError("Invalid data");
            }
        }
     else {
         view.onLoginError("Invalid data");
     }
    }
    public boolean isAuth(){
        return PrefHelper.getBooleanVal("Auth");
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
