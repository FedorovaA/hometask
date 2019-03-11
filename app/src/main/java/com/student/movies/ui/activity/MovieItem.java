package com.student.movies.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.student.movies.DAO.DataObject;
import com.student.movies.R;
import com.student.movies.model.Movie;

public class MovieItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        Movie movie = DataObject.getInstance().getMovie();

        TextView txtTitle = findViewById(R.id.item_title);
        TextView txtYear = findViewById(R.id.item_year);
        TextView txtMark = findViewById(R.id.item_mark);
        TextView txtNumber = findViewById(R.id.item_number);
        TextView txtDescription = findViewById(R.id.item_sinops);
        TextView txtCountry = findViewById(R.id.item_country);
        TextView txtAwards = findViewById(R.id.item_awards);
        TextView txtActors = findViewById(R.id.item_actors);
        TextView txtSite = findViewById(R.id.item_site);
        ImageView imgPoster = findViewById(R.id.item_poster);

        txtTitle.setText(movie.getMovieTitle());
        txtYear.setText(movie.getMovieYear());
        txtMark.setText(movie.getMovieMark());
        txtNumber.setText(Integer.toString(movie.getMovieNumbers()));
        txtDescription.setText(movie.getMovieDescription());
        txtCountry.setText(movie.getMovieCountry());
        txtAwards.setText(movie.getMovieAwards());
        txtActors.setText(movie.getMovieActors());
        txtSite.setText(movie.getMovieSite());
        imgPoster.setImageDrawable(getDrawable(getResources().getIdentifier(movie.getMoviePoster(),"drawable",getPackageName())));
        imgPoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
