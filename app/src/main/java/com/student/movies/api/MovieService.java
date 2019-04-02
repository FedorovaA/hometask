package com.student.movies.api;

import android.database.Observable;

import com.student.movies.api.data.MovieData;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {
    @GET("fetchMovies")
    Single<Response<List<MovieData>>> fetchMovies(@Query("sort") String sort);

    @GET("fetchMovie/{movieId}")
    Single<Response<MovieData>> fetchMovie(@Path("movieId") long movieId);

    @DELETE("deleteMovie/{movieId}")
    Single<Response<Boolean>> deleteMovie(@Path("movieId") long movieId);

    @PUT("updateMovie")
    Single<Response<MovieData>> updateMovie(@Body MovieData movieData);

    @POST("createMovie")
    Single<Response<MovieData>> createMovie(@Body MovieData movieData);

}
