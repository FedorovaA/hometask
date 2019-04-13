package com.student.movies.api;

import android.database.Observable;

import com.student.movies.api.data.MovieData;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {
    @GET("api/movies/fetchMovies")
    Single<Response<List<MovieData>>> fetchMovies(@Header ("Authorization") String header,@Query("sort") String sort);

    @GET("api/movies/fetchMovie/{movieId}")
    Single<Response<MovieData>> fetchMovie(@Header ("Authorization") String header,@Path("movieId") long movieId);

    @DELETE("api/movies/deleteMovie/{movieId}")
    Single<Response<Boolean>> deleteMovie(@Header ("Authorization") String header,@Path("movieId") long movieId);

    @PUT("api/movies/updateMovie")
    Single<Response<MovieData>> updateMovie(@Header ("Authorization") String header,@Body MovieData movieData);

    @POST("api/movies/createMovie")
    Single<Response<MovieData>> createMovie(@Header ("Authorization") String header,@Body MovieData movieData);

}
