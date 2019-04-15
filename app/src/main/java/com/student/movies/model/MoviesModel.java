package com.student.movies.model;

import com.student.movies.api.MovieService;
import com.student.movies.api.RestApi;
import com.student.movies.api.SingleResponseFlatMap;
import com.student.movies.api.data.MovieData;
import com.student.movies.utils.MovieConverter;

import java.util.List;

import io.reactivex.Single;
import okhttp3.Response;

public class MoviesModel {
    protected MovieService movieService;
    public MoviesModel(){movieService = RestApi.createService(MovieService.class);}

//    public Single<List<Movie>> fetchMovies(String header,String sort){
//        return movieService.fetchMovies(header,sort)
//                .flatMap(new SingleResponseFlatMap<>())
//                .map(MovieConverter::convertMoviesToListDomain);
//    }
//    public Single<List<Movie>> fetchMovies(String header,String sort) {
//        return movieService.fetchMovies(header,sort)
//                .flatMap(new SingleObserbe)
//                .map()
//    }

    public Single<Movie> fetchMovie(String header,long movieId){
        return movieService.fetchMovie(header,movieId)
                .flatMap(new SingleResponseFlatMap<>())
                .map(MovieConverter::convertToDomain);
    }

    public Single<Boolean> deleteMovie(String header,long movieId){
        return movieService.deleteMovie(header,movieId)
                .flatMap(new SingleResponseFlatMap<>())
                .map(v->v);
    }

    public Single<Movie> updateMovie(String header,MovieData movieData){
        return movieService.updateMovie(header,movieData)
                .flatMap(new SingleResponseFlatMap<>())
                .map(MovieConverter::convertToDomain);
    }
    public Single<Movie> createMovie(String header,MovieData movieData){
        return movieService.createMovie(header,movieData)
                .flatMap(new SingleResponseFlatMap<>())
                .map(MovieConverter::convertToDomain);
    }
}
