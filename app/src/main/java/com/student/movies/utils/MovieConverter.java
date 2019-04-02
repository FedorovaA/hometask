package com.student.movies.utils;

import com.student.movies.api.data.MovieData;
import com.student.movies.model.Movie;

import java.util.ArrayList;
import java.util.List;

public final class MovieConverter {
    private MovieConverter() {
    }
    public static Boolean Result(Boolean res){
        final Boolean result = res;
        return result;
    }
    public static Movie convertToDomain(MovieData movieData) {
        return new Movie(movieData.getId(), movieData.getTitle(),movieData.getYear(),
                movieData.getRate(),movieData.getPoster(),movieData.getDescription(),movieData.getAwards(),movieData.getActors(),
                movieData.getWebsite());
    }
    public static Movie convertMoviesToDomain(MovieData movieData){
        return new Movie(movieData.getId(), movieData.getTitle(),movieData.getYear(),
                movieData.getRate(),movieData.getPoster(),movieData.getDescription());
    }
    public static List<Movie> convertMoviesToListDomain(List<MovieData> dataList){
        final List<Movie> movies = new ArrayList<>();
        for (MovieData movieData : dataList) {
            movies.add(convertMoviesToDomain(movieData));
        }
        return movies;
    }
}
