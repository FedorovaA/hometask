package com.student.movies.model;

import com.student.movies.api.RegisterService;
import com.student.movies.api.RestApi;
import com.student.movies.api.SingleResponseFlatMap;
import com.student.movies.api.data.RegisterData;
import com.student.movies.api.data.TokenResponse;
import com.student.movies.utils.Constants;
import com.student.movies.utils.RegisterConverter;

import io.reactivex.Single;

public class RegisterModel {
    protected RegisterService registerService;
    public RegisterModel(){registerService = RestApi.createService(RegisterService.class); }
    public Single<RegisterData> onRegister(RegisterData registerData){
        return registerService.onRegister(registerData)
                .flatMap(new SingleResponseFlatMap<>())
                .map(RegisterConverter::convertStatus);
    }
    public Single<TokenResponse> signInByPassword(String header,
                                                  String username,
                                                  String password,
                                                  String grandType){
        return registerService.signInByPassword(header,username,password,grandType)
                .flatMap(new SingleResponseFlatMap<>())
                .map(item->item);
    }

}
