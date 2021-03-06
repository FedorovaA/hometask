package com.student.movies.presenter;

import android.os.Bundle;
import android.util.Log;


import com.student.movies.model.Movie;
import com.student.movies.model.MoviesModel;
import com.student.movies.utils.Constants;
import com.student.movies.view.MovieListView;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import khangtran.preferenceshelper.PrefHelper;


public class MovieListPresenter extends BasePresenter<MovieListView> implements IMovieListPresenter {
    private MoviesModel moviesModel;


    public MovieListPresenter(){
        moviesModel = new MoviesModel();
    }


    @Override
    public void onCreate(Bundle saveInstance) {
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void loadMovies() {
        view.showLoadingDialog("Loading");
            Disposable disposable = moviesModel.fetchMovies(Constants.TOKEN_PREFIX + PrefHelper.getStringVal(Constants.TOKEN), "desc")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doAfterTerminate(() -> view.dismissLoadingDialog())
                    .subscribe(list -> {
                                view.showMovies(list);
                            },
                            e -> {
                                view.showToast(e.getMessage());
                                e.printStackTrace();
                            });
            addSubscription(disposable);
    }
}
