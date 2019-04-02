package com.student.movies.presenter;

import android.os.Bundle;

import com.student.movies.model.MoviesModel;
import com.student.movies.view.MovieAboutFragmentView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MovieAboutFragmentPresenter extends BasePresenter<MovieAboutFragmentView> implements IMovieAboutFragmentPresenter {
    private MoviesModel moviesModel;


    public MovieAboutFragmentPresenter(){
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
    public void loadMovie(long id) {
        Disposable disposable = moviesModel.fetchMovie(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item->{view.showItemMovie(item);},
                        e->{view.showToast(e.getMessage());});
        addSubscription(disposable);
    }

    @Override
    public void deleteMovie(long id) {
        Disposable disposable = moviesModel.deleteMovie(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item->{view.showMessage(item);},
                        e->{view.showToast(e.getMessage());});
        addSubscription(disposable);
    }
}
