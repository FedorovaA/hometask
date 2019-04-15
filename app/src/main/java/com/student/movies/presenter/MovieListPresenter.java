package com.student.movies.presenter;

import android.os.Bundle;
import android.util.Log;


import com.student.movies.api.MovieService;
import com.student.movies.api.RestApi;
import com.student.movies.api.data.MovieData;
import com.student.movies.model.Movie;
import com.student.movies.model.MoviesModel;
import com.student.movies.utils.Constants;
import com.student.movies.view.MovieListView;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import khangtran.preferenceshelper.PrefHelper;
import retrofit2.Response;


public class MovieListPresenter extends BasePresenter<MovieListView> implements IMovieListPresenter {
    private MoviesModel moviesModel;
    private MovieService movieService;

    public MovieListPresenter(){
        moviesModel = new MoviesModel();
        movieService = RestApi.createService(MovieService.class);
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
       movieService.fetchMovies(Constants.TOKEN_PREFIX + PrefHelper.getStringVal(Constants.TOKEN), "desc")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new SingleObserver<Response<List<MovieData>>>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onSuccess(Response<List<MovieData>> listResponse) {
                       if(listResponse.isSuccessful()) {
                           view.showMovies(listResponse.body());
                       }
                       else {
                           view.showToast("error");
                       }
                   }

                   @Override
                   public void onError(Throwable e) {
                       view.showToast("error");
                       e.printStackTrace();
                   }
               });
    }
}
