package com.student.movies.presenter;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.student.movies.DAO.DataObject;
import com.student.movies.model.Movie;
import com.student.movies.view.MovieListView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MovieListPresenter extends BasePresenter<MovieListView> {
    private List<Movie> movies;

    public MovieListPresenter(){}

    @Override
    public void onCreate(Bundle saveInstance) {
        movies = DataObject.getInstance().getMovies();
        Collections.sort(movies,new Comparator<Movie>(){
            public int compare(Movie o1, Movie o2){
                return o1.getMovieMark().compareTo(o2.getMovieMark());
            }
        });
        view.showMovies(movies);
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
}
