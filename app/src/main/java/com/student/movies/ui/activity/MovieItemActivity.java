package com.student.movies.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.student.movies.MyApplication;
import com.student.movies.R;
import com.student.movies.model.Movie;
import com.student.movies.presenter.MovieAboutFragmentPresenter;
import com.student.movies.view.MovieAboutFragmentView;

public class MovieItemActivity extends AppCompatActivity implements MovieAboutFragment.OnFragmentInteractionListener, MovieChangeFragment.OnFragmentInteractionListener {
MovieAboutFragment movieAboutFragment;
MovieChangeFragment movieChangeFragment;
private String movieId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        movieId = getIntent().getStringExtra("MOVIEID");
        if(!movieId.equals("-1")) {
            aboutFragment(Long.parseLong(movieId));
        }else {
            otherFragment(movieId);
        }
    }


    @Override
    public void otherFragment(String param) {
        movieChangeFragment = MovieChangeFragment.newInstance(param);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.movie_frag,movieChangeFragment)
                .commit();

    }


        @Override
    public void onActivity() {
        finish();
    }


    @Override
    public void aboutFragment(Long id) {
        movieAboutFragment = MovieAboutFragment.newInstance(String.valueOf(id));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.movie_frag,movieAboutFragment)
                .commit();
    }
}
