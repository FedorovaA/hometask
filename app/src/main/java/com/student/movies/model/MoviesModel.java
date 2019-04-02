package com.student.movies.model;

import com.student.movies.api.MovieService;
import com.student.movies.api.RestApi;
import com.student.movies.api.SingleResponseFlatMap;
import com.student.movies.api.data.MovieData;
import com.student.movies.utils.MovieConverter;

import java.util.List;

import io.reactivex.Single;

public class MoviesModel {
    protected MovieService movieService;
    public MoviesModel(){movieService = RestApi.createService(MovieService.class);}

    public Single<List<Movie>> fetchMovies(String sort){
        return movieService.fetchMovies(sort)
                .flatMap(new SingleResponseFlatMap<>())
                .map(MovieConverter::convertMoviesToListDomain);
    }

    public Single<Movie> fetchMovie(long movieId){
        return movieService.fetchMovie(movieId)
                .flatMap(new SingleResponseFlatMap<>())
                .map(MovieConverter::convertToDomain);
    }

    public Single<Boolean> deleteMovie(long movieId){
        return movieService.deleteMovie(movieId)
                .flatMap(new SingleResponseFlatMap<>())
                .map(v->v);
    }

    public Single<Movie> updateMovie(MovieData movieData){
        return movieService.updateMovie(movieData)
                .flatMap(new SingleResponseFlatMap<>())
                .map(MovieConverter::convertToDomain);
    }
    public Single<Movie> createMovie(MovieData movieData){
        return movieService.createMovie(movieData)
                .flatMap(new SingleResponseFlatMap<>())
                .map(MovieConverter::convertToDomain);
    }
}
