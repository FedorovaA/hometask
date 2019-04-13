package com.student.movies.api;

import android.support.v4.media.AudioAttributesCompat;
import android.support.v4.media.VolumeProviderCompat;

import com.student.movies.api.data.RegisterData;
import com.student.movies.api.data.TokenResponse;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RegisterService {

    @POST("auth/register")
    Single<Response<RegisterData>> onRegister(@Body RegisterData registerData);

    @FormUrlEncoded
    @POST("oauth/token")
    Single<Response<TokenResponse>> signInByPassword(@Header ("Authorization") String header,
                                                     @Field("username") String username,
                                                     @Field("password") String password,
                                                     @Field("grant_type") String grant_type);
    @FormUrlEncoded
    @POST("oauth/token")
    Call<TokenResponse> refreshToken(@Field("refresh_token") String refreshToken, @Field("grant_type") String grantType);

}
