package com.student.movies.view;

public interface AuthorizationView extends BaseView {
    void onLoginSuccess(String message);
    void onLoginError(String message);
    void onMovies();
}
