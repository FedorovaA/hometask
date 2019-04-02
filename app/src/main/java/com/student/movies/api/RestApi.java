package com.student.movies.api;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApi {
    public static String BASE_URL = "http://192.168.0.14:8080/";

    private static Retrofit retrofit = null;

    public static void init(Context context) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient.addInterceptor(interceptor);

        Gson gson = new GsonBuilder().create();
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient.build())
                .build();
    }

    public static <T> T createService(Class<T> serviceClass) {
        if (retrofit == null) {
            throw new IllegalStateException("Call `RestApi.init(Context, Authenticator)` before calling this method.");
        }
        return retrofit.create(serviceClass);
    }

}
