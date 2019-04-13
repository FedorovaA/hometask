package com.student.movies.api;

import android.content.Context;
import android.support.annotation.NonNull;

import com.student.movies.utils.Constants;

import java.io.IOException;

import khangtran.preferenceshelper.PrefHelper;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BearerAuthorizationInterceptor implements Interceptor {
    private static final String TAG = "Interceptor";

    private Context context;

    private static final String BASIC_TOKEN = "bXktY2xpZW50Om15LXNlY3JldA==";

    public BearerAuthorizationInterceptor(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        String token = PrefHelper.getStringVal(Constants.TOKEN,null);//Prefs.get().getString(Prefs.Keys.Token.toString(), null);

        Request.Builder builder = chain.request().newBuilder();
        if(chain.request().url().encodedPath().contains("auth/")){
            builder.addHeader("Content-Type","application/json");
        }
        else {
            if (chain.request().headers().get(Constants.AUTHORIZATION_HEADER) == null) {
                if (chain.request().url().encodedPath().contains("oauth/")) {
                    builder.addHeader(Constants.AUTHORIZATION_HEADER, Constants.TOKEN_PREFIX_BASIC + BASIC_TOKEN);
                } else {
                    builder.addHeader(Constants.AUTHORIZATION_HEADER, Constants.TOKEN_PREFIX + token);
                }
            }
        }
        return chain.proceed(builder.build());
    }
}
