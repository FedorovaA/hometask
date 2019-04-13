package com.student.movies.utils;

import com.student.movies.api.data.RegisterData;

public final class RegisterConverter {
    private RegisterConverter(){}
    public static RegisterData convertStatus(RegisterData registerData){
        return new RegisterData(registerData.getStatus());
    }
}
