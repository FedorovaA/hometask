package com.student.movies.ui.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.student.movies.R;
import com.student.movies.model.Movie;
import com.student.movies.presenter.MovieListPresenter;
import com.student.movies.ui.activity.adapters.MovieListAdapter;
import com.student.movies.view.MovieListView;

import java.util.List;

public class MovieListActivity extends AppCompatActivity implements MovieListView {
    private MovieListAdapter movieListAdapter;
    private MovieListPresenter movieListPresenter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private AlertDialog builder;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        movieListPresenter = new MovieListPresenter();
        movieListPresenter.setView(this);
        builder = new AlertDialog.Builder(getContext()).create();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MovieItemActivity.class);
                intent.putExtra("MOVIEID","-1");
                startActivity(intent);
                finish();
            }
        });
        movieListAdapter = new MovieListAdapter(this);
        recyclerView = findViewById(R.id.recv_movies);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(movieListAdapter);
        swipeRefreshLayout = findViewById(R.id.movieSwipe);
        swipeRefreshLayout.setOnRefreshListener(() -> movieListPresenter.loadMovies());
        movieListPresenter.loadMovies();

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

    @Override
    public void showLoadingDialog(String message) {
        builder.setTitle(message);
        builder.setCancelable(false);
        builder.show();


    }

    @Override
    public void dismissLoadingDialog() {
        builder.dismiss();
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }

    }

    @Override
    public void showToast(String message) {
        Toast.makeText(MovieListActivity.this,message,Toast.LENGTH_SHORT).show();
    }
}
