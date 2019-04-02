package com.student.movies.view;

import com.student.movies.model.Movie;

public interface MovieAboutFragmentView extends BaseView {
    void showItemMovie(Movie movie);
    void showMessage(Boolean res);
}
