package com.student.movies.ui.activity.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.student.movies.R;
import com.student.movies.model.Movie;
import com.student.movies.ui.activity.MovieItem;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private List<Movie> movies = new ArrayList<>();
    Context context;
    private String movieId;

    public MovieListAdapter(Context context) {this.context = context;}

    public void setMovies (List<Movie> movies) {this.movies = movies;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_list, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Movie movie = movies.get(position);
                    movieId = String.valueOf(movie.getMovieNumbers());
                    Intent intent = new Intent(context, MovieItem.class);
                    intent.putExtra("MOVIEID",movieId);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    context.startActivity(intent);
                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Movie movie = movies.get(i);
        String str;
        str = movie.getMovieDescription();
        viewHolder.txtTitle.setText(movie.getMovieTitle());
        viewHolder.txtYear.setText(String.valueOf(movie.getMovieYear()));
        viewHolder.txtNumber.setText(String.valueOf(movie.getMovieNumbers()));
        viewHolder.txtDescription.setText(str.substring(0, str.indexOf(".") + 1));
        viewHolder.txtMark.setText(String.valueOf(movie.getMovieMark()));
        if (movie.getMoviePoster() != null) {
            viewHolder.imgPoster.setImageDrawable(context.getDrawable(
                    context.getResources().getIdentifier(
                            movie.getMoviePoster(), "drawable", context.getPackageName())));
        }
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
