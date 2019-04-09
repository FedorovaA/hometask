package com.student.movies.view;

import com.student.movies.model.Movie;

public interface MovieChangeView extends BaseView {
    void showItemMovie(Movie movie);
    void onOtherFragment(Long id);
}
