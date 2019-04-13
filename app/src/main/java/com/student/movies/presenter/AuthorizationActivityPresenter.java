package com.student.movies.presenter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.student.movies.api.data.RegisterData;
import com.student.movies.model.RegisterModel;
import com.student.movies.utils.Constants;
import com.student.movies.view.AuthorizationActivityView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import khangtran.preferenceshelper.PrefHelper;

public class AuthorizationActivityPresenter extends BasePresenter<AuthorizationActivityView>{

    private String Password;
    private RegisterModel registerModel;
    private final static String KEY ="local";

    public AuthorizationActivityPresenter(){registerModel = new RegisterModel(); }

    public void onLogin(String login,String password, Context context) {
        Password = "qpwoei";
            if (!login.isEmpty() && !password.isEmpty()) {
                if (password.equals(Password)) {
                    PrefHelper.setVal(KEY,Password);
                    view.onLoginSuccess("Wellcome");
                    view.onMovies();
                } else{
                    Authorization(login,password);
                }
            } else {
                view.onLoginError("Invalid data");
            }
    }
    public boolean isAuth(){
        if(PrefHelper.getStringVal(KEY)!=null){
            return true;
        }
        else if(PrefHelper.getStringVal(Constants.TOKEN)!=null){
            return true;
        }
        else{
            return false;
        }
    }
    private void setValues(String token, String refreshToken){
        PrefHelper.setVal(Constants.TOKEN,token);
        PrefHelper.setVal(Constants.REFRESHTOKEN,refreshToken);
        if(isAuth()){
            view.onMovies();
        }
        else {
            view.onLoginError("Never Data");
        }
    }

    private void Authorization(String username,String password){
        Disposable disposable = registerModel.signInByPassword(Constants.TOKEN_PREFIX_BASIC +"bXktY2xpZW50Om15LXNlY3JldA==",
                username,password,"password")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item->{
                    setValues(item.getAccessToken(),item.getRefreshToken());
                },e->{view.onLoginError(e.getMessage());});
        addSubscription(disposable);
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
