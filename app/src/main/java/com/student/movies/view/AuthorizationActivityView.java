package com.student.movies.view;

public interface AuthorizationActivityView extends BaseView {
    void onLoginSuccess(String message);
    void onLoginError(String message);
    void onMovies();
}
