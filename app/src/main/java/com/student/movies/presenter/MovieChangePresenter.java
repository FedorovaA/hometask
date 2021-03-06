package com.student.movies.presenter;

import android.os.Bundle;

import com.student.movies.api.data.MovieData;
import com.student.movies.model.MoviesModel;
import com.student.movies.utils.Constants;
import com.student.movies.view.MovieChangeView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import khangtran.preferenceshelper.PrefHelper;

public class MovieChangePresenter extends BasePresenter<MovieChangeView> implements IMovieChangePresenter {
    private MoviesModel moviesModel;

    public MovieChangePresenter() {
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
    public void loadMovie(Long id) {
        Disposable disposable = moviesModel.fetchMovie(Constants.AUTHORIZATION_HEADER+Constants.TOKEN_PREFIX+PrefHelper.getStringVal(Constants.TOKEN),id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item->{view.showItemMovie(item);},
                        e->{view.showToast(e.getMessage());});
        addSubscription(disposable);
    }

    @Override
    public void updateMovie(MovieData movie) {
        Disposable disposable = moviesModel.updateMovie(Constants.AUTHORIZATION_HEADER+Constants.TOKEN_PREFIX+PrefHelper.getStringVal(Constants.TOKEN),movie)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item->{view.onOtherFragment(item.getMovieNumbers());},
                        e->{view.showToast(e.getMessage());});
        addSubscription(disposable);
    }

    @Override
    public void createMovie(MovieData movie) {

        Disposable disposable = moviesModel.createMovie(Constants.AUTHORIZATION_HEADER+Constants.TOKEN_PREFIX+PrefHelper.getStringVal(Constants.TOKEN),movie)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item->{view.onOtherFragment(item.getMovieNumbers());},
                        e->{view.showToast(e.getMessage());});
        addSubscription(disposable);
    }
}
