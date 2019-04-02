package com.student.movies;

import android.app.Application;

import com.student.movies.api.RestApi;

import khangtran.preferenceshelper.PrefHelper;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RestApi.init(this);
        PrefHelper.initHelper(this);
    }
}
