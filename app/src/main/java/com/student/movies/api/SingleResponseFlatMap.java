package com.student.movies.api;

import io.reactivex.Single;
import io.reactivex.functions.Function;
import retrofit2.Response;

public class SingleResponseFlatMap<T> implements Function<Response<T>, Single<T>> {
    @Override
    public Single<T> apply(Response<T> tResponse) throws Exception {
        if(!tResponse.isSuccessful()){
            return Single.error(new RuntimeException(String.valueOf(tResponse.code())));
        }else{
            return Single.just(tResponse.body());
        }
    }
}
