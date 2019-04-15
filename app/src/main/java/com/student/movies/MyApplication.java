package com.student.movies;

import android.app.Application;
import android.content.Intent;

import com.student.movies.api.RegisterService;
import com.student.movies.api.RestApi;
import com.student.movies.api.data.TokenResponse;
import com.student.movies.ui.activity.AuthorizationActivity;
import com.student.movies.utils.Constants;

import khangtran.preferenceshelper.PrefHelper;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        PrefHelper.initHelper(this);
        //RestApi.init();
        RestApi.init(this,(route, response) -> {

            String refreshToken = PrefHelper.getStringVal(Constants.REFRESHTOKEN,null);//Prefs.get().getString(Prefs.Keys.RefreshToken.toString(), null);

            if (refreshToken != null){

                //LoginController.getInstance().setAccessToken(null);
                PrefHelper.removeAllKeys();
                TokenResponse tokenResponse = RestApi.createService(RegisterService.class)
                        .refreshToken(refreshToken, "refresh_token")
                        .execute().body();
                if (tokenResponse != null){
//                    LoginController.getInstance().setAccessToken(tokenResponse.getAccessToken());
//                    LoginController.getInstance().setRefreshToken(tokenResponse.getRefreshToken());
                    PrefHelper.setVal(Constants.TOKEN,tokenResponse.getAccessToken());
                    PrefHelper.setVal(Constants.REFRESHTOKEN,tokenResponse.getRefreshToken());
                    return response.request().newBuilder()
                            .addHeader(Constants.AUTHORIZATION_HEADER, Constants.TOKEN_PREFIX + tokenResponse.getAccessToken())
                            .build();
                } else {
                    Intent intent = new Intent(getApplicationContext(), AuthorizationActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }

            } else {
                Intent intent = new Intent(getApplicationContext(), AuthorizationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

            return null;
        });
    }
}
