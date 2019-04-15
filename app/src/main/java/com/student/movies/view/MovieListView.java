package com.student.movies.view;

import com.student.movies.api.data.MovieData;
import com.student.movies.model.Movie;

import java.util.List;

public interface MovieListView extends BaseView {
    void showMovies(List<MovieData> movies);
    void showLoadingDialog(String message);
    void dismissLoadingDialog();
}
