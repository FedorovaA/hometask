package com.student.movies.ui.activity.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.student.movies.R;
import com.student.movies.model.Movie;
import com.student.movies.presenter.LifePresenter;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private List<Movie> movies = new ArrayList<>();
    Context context;

    public MovieListAdapter(Context context) {this.context = context;}

    public void setMovies (List<Movie> movies) {this.movies = movies;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Movie movie = movies.get(i);
        viewHolder.txtTitle.setText(movie.getMovieTitle());
        viewHolder.txtYear.setText(movie.getMovieYear());
        viewHolder.txtNumber.setText(Integer.toString(movie.getMovieNumbers()));
        viewHolder.txtDescription.setText(new StringBuilder(movie.getMovieDescription().substring(0, 20))
                .append("..."));
        viewHolder.txtMark.setText(movie.getMovieMark());
        viewHolder.imgPoster.setImageDrawable(context.getDrawable(
                context.getResources().getIdentifier(
                        movie.getMoviePoster(), "drawable", context.getPackageName())));
    }

    @Override
    public int getItemCount() {
        return movies != null ? movies.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtYear;
        TextView txtMark;
        TextView txtNumber;
        TextView txtDescription;
        ImageView imgPoster;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtYear = itemView.findViewById(R.id.txt_year);
            txtMark = itemView.findViewById(R.id.txt_mark);
            txtNumber = itemView.findViewById(R.id.txt_number);
            txtDescription = itemView.findViewById(R.id.txt_sinops);
            imgPoster = itemView.findViewById(R.id.poster);
        }
    }
}
