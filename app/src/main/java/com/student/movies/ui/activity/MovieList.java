package com.student.movies.ui.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.student.movies.R;
import com.student.movies.model.Movie;
import com.student.movies.presenter.MovieListPresenter;
import com.student.movies.ui.activity.adapters.MovieListAdapter;
import com.student.movies.view.MovieListView;

import java.util.List;

public class MovieList extends AppCompatActivity implements MovieListView {
    MovieListPresenter movieListPresenter;
    RecyclerView recyclerView;
    private MovieListAdapter movieListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        movieListPresenter = new MovieListPresenter();
        movieListPresenter.setView(this);
        movieListAdapter = new MovieListAdapter(getContext());
        recyclerView = findViewById(R.id.rv_movies);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(movieListAdapter);
        movieListPresenter.onCreate(savedInstanceState);

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showMovies(List<Movie> movies) {
        movieListAdapter.setMovies(movies);
        movieListAdapter.notifyDataSetChanged();
    }
}
