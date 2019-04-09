package com.student.movies.presenter;

import com.student.movies.api.data.MovieData;
import com.student.movies.model.Movie;

public interface IMovieChangePresenter {
    void loadMovie(Long id);
    void updateMovie(MovieData movie);
    void createMovie(MovieData movie);
}
