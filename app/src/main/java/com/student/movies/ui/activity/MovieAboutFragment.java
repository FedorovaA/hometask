package com.student.movies.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.student.movies.R;
import com.student.movies.model.Movie;
import com.student.movies.presenter.MovieAboutFragmentPresenter;
import com.student.movies.view.MovieAboutFragmentView;


public class MovieAboutFragment extends Fragment implements MovieAboutFragmentView {
    private MovieAboutFragmentPresenter movieAboutFragmentPresenter;
    private TextView txtTitle;
    private TextView txtNumber;
    private TextView txtYear;
    private TextView txtMark;
    private TextView txtAwards;
    private TextView txtDescription;
    private TextView txtActors;
    private TextView txtSite;
    private ImageView imgPoster;
    MenuInflater menuInflater;


    private static final String MOVIEID = "movieId";

    private String mMovieId;

    private OnFragmentInteractionListener mListener;

    public MovieAboutFragment() {
    }

    public static MovieAboutFragment newInstance(String param1) {
        MovieAboutFragment fragment = new MovieAboutFragment();
        Bundle args = new Bundle();
        args.putString(MOVIEID, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMovieId = getArguments().getString(MOVIEID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_about, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar1);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        menuInflater = getActivity().getMenuInflater();
        movieAboutFragmentPresenter = new MovieAboutFragmentPresenter();
        movieAboutFragmentPresenter.setView(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtTitle = view.findViewById(R.id.item_title);
        txtYear = view.findViewById(R.id.item_year);
        txtMark = view.findViewById(R.id.item_mark);
        txtNumber = view.findViewById(R.id.item_number);
        txtDescription = view.findViewById(R.id.item_sinops);
        txtAwards = view.findViewById(R.id.item_awards);
        txtActors = view.findViewById(R.id.item_actors);
        txtSite = view.findViewById(R.id.item_site);
        imgPoster = view.findViewById(R.id.item_poster);
        movieAboutFragmentPresenter.loadMovie(Long.parseLong(mMovieId));


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.icons,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_delete){
            movieAboutFragmentPresenter.deleteMovie(Long.parseLong(txtNumber.getText().toString()));
        }
        if(item.getItemId() == R.id.action_edit){
            mListener.otherFragment(mMovieId);
        }
        if(item.getItemId()==R.id.action_back){
            onActivity();
        }
        return true;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showItemMovie(Movie movie) {
        txtTitle.setText(movie.getMovieTitle());
        txtYear.setText(String.valueOf(movie.getMovieYear()));
        txtMark.setText(String.valueOf(movie.getMovieMark()));
        txtNumber.setText(String.valueOf(movie.getMovieNumbers()));
        txtDescription.setText(movie.getMovieDescription());
        txtAwards.setText(movie.getMovieAwards());
        txtActors.setText(movie.getMovieActors());
        txtSite.setText(movie.getMovieSite());
        if(movie.getMoviePoster()!=null) {
            imgPoster.setImageDrawable(getActivity().getDrawable(getResources().getIdentifier(movie.getMoviePoster(), "drawable", getActivity().getPackageName())));
        }
    }

    @Override
    public void showMessage(Boolean res) {
        if(res){
            showToast("Удалено");
        }
        else {
            showToast("Такого фильма нет");
        }
        onActivity();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
    }
    private void onActivity(){
        Intent intent = new Intent(getContext(), MovieListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public interface OnFragmentInteractionListener {
        void otherFragment(String param);
    }
}
