package com.student.movies.presenter;

import android.os.Bundle;
import android.support.annotation.MainThread;

import com.student.movies.api.data.RegisterData;
import com.student.movies.model.RegisterModel;
import com.student.movies.utils.Constants;
import com.student.movies.view.RegisterActivityView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import khangtran.preferenceshelper.PrefHelper;

public class RegisterActivityPresenter extends BasePresenter<RegisterActivityView> {

    private String loginPres;
    private String passwordPres;



    private RegisterModel registerModel;

    public RegisterActivityPresenter(){registerModel = new RegisterModel();}

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

    public void isRegister(RegisterData registerData){
        Disposable disposable = registerModel.onRegister(registerData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item->{
                    if(item.getStatus().equals("Successful")){
                        signIn(Constants.TOKEN_PREFIX_BASIC +"bXktY2xpZW50Om15LXNlY3JldA==",
                                this.loginPres,this.passwordPres,"password");
                    }
                    else{
                        view.onRegister(item.getStatus());
                    }
                        },
                        e->{view.onRegister(e.getMessage());});
        addSubscription(disposable);
    }
    public RegisterData register(String login, String password){
        this.loginPres = login;
        this.passwordPres = password;
        return new RegisterData(login,password);
    }

    private void setValues(String t, String r){
        PrefHelper.removeAllKeys();
        PrefHelper.setVal(Constants.TOKEN,t);
        PrefHelper.setVal(Constants.REFRESHTOKEN,r);
        view.onRegister("Success");
        view.onAuthActivity();
    }

    public void signIn(String header,
                        String username,
                        String password,
                        String grandType){
        Disposable disposable = registerModel.signInByPassword(header,username,password,grandType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item->{
                   setValues(item.getAccessToken(),item.getRefreshToken());
                },e->{e.getMessage();});
        addSubscription(disposable);
    }
}
