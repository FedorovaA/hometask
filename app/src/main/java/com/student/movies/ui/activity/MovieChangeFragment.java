package com.student.movies.ui.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.student.movies.R;
import com.student.movies.api.data.MovieData;
import com.student.movies.model.Movie;
import com.student.movies.presenter.MovieAboutFragmentPresenter;
import com.student.movies.presenter.MovieChangePresenter;
import com.student.movies.view.MovieChangeView;


public class MovieChangeFragment extends Fragment implements MovieChangeView {
    private MovieChangePresenter movieChangePresenter;
    private EditText txtTitle;
    private TextView txtNumber;
    private EditText txtYear;
    private EditText txtMark;
    private EditText txtAwards;
    private EditText txtDescription;
    private EditText txtActors;
    private Button btn;
    private CheckBox chek;
    private EditText txtSite;
    private ImageView imgPoster;
    private String txtImagePoster = null;

    private static final String MOVIEID = "MovieId";

    private String mMovieId;

    private OnFragmentInteractionListener mListener;

    public MovieChangeFragment() {
    }


    public static MovieChangeFragment newInstance(String param1) {
        MovieChangeFragment fragment = new MovieChangeFragment();
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
        View view = inflater.inflate(R.layout.fragment_movie_change, container, false);
        movieChangePresenter = new MovieChangePresenter();
        movieChangePresenter.setView(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtTitle = view.findViewById(R.id.item_title1);
        txtYear = view.findViewById(R.id.item_year1);
        txtYear.addTextChangedListener(yearWatcher);
        txtMark = view.findViewById(R.id.item_mark1);
        txtMark.addTextChangedListener(rateWatcher);
        txtNumber = view.findViewById(R.id.item_number1);
        txtDescription = view.findViewById(R.id.item_sinops1);
        txtAwards = view.findViewById(R.id.item_awards1);
        txtActors = view.findViewById(R.id.item_actors1);
        txtSite = view.findViewById(R.id.item_site1);
        imgPoster = view.findViewById(R.id.item_poster1);
        chek = view.findViewById(R.id.checkBox1);
        btn = view.findViewById(R.id.button1);
        if(!mMovieId.equals("-1")){
            btn.setText("Изменить");
            txtNumber.setVisibility(View.VISIBLE);
            movieChangePresenter.loadMovie(Long.parseLong(mMovieId));
        }
        else {
            btn.setText("Добавить");
        }
        btn.setOnClickListener(v->{Options();});
        chek.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    txtSite.setVisibility(View.VISIBLE);
                }
                else {
                    txtSite.setVisibility(View.GONE);
                }
            }
        });

    }

    private void Options(){
        if(mMovieId.equals("-1")){
            movieChangePresenter.createMovie(crMovie());

        }
        else {
            movieChangePresenter.updateMovie(upMovie());
        }
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

    private MovieData crMovie(){
        final MovieData movieData = new MovieData();
            if (txtSite.getText().toString().isEmpty()) {
                txtSite.setText("N/A");
            }
            movieData.setTitle(txtTitle.getText().toString());
            movieData.setYear(Integer.parseInt(txtYear.getText().toString()));
            movieData.setActors(txtActors.getText().toString());
            movieData.setDescription(txtDescription.getText().toString());
            movieData.setAwards(txtAwards.getText().toString());
            movieData.setPoster(txtImagePoster);
            movieData.setWebsite(txtSite.getText().toString());
            movieData.setRate(Double.parseDouble(txtMark.getText().toString()));
        return movieData;
    }

    private MovieData upMovie(){
        final MovieData movieData = new MovieData();
        movieData.setId(Long.parseLong((String) txtNumber.getText()));
        movieData.setTitle(txtTitle.getText().toString());
        movieData.setYear(Integer.parseInt(txtYear.getText().toString()));
        movieData.setActors(txtActors.getText().toString());
        movieData.setDescription(txtDescription.getText().toString());
        movieData.setAwards(txtAwards.getText().toString());
        movieData.setPoster(txtImagePoster);
        movieData.setWebsite(txtSite.getText().toString());
        movieData.setRate(Double.parseDouble(txtMark.getText().toString()));
        return movieData;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
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
            txtImagePoster = movie.getMoviePoster();
        }
    }

    private TextWatcher rateWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
                if (s.length() > 2) {
                    if (!(s.charAt(0) >= '0' && s.charAt(0) <= '9') && s.length()==3) {
                        s.clear();
                    } else if (!(s.charAt(1) == '.')&& s.length()==3) {
                        s.clear();
                    } else if (!(s.charAt(2) >= '0' && s.charAt(2) <= '9')&& s.length()==3) {
                        s.clear();
                    } else if(s.length()==4 &&!(s.charAt(0)=='1' && s.charAt(1)=='0' && s.charAt(2)=='.' && s.charAt(3)=='0')){
                        s.clear();
                    }
                }
            else if(s.length()>4){
                s.clear();
            }
        }
    };

    private TextWatcher yearWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s.length()==4) {
                if (s.charAt(0) < '1' && s.charAt(0) > '2') {
                    s.clear();
                } else if (s.charAt(1) < '8' && s.charAt(0) == '1') {
                    s.clear();
                } else if (s.charAt(1) > '1' && s.charAt(0) == '2') {
                    s.clear();
                } else if (s.charAt(2) < '5' && s.charAt(0) == '1' && s.charAt(1) >= '8') {
                    s.clear();
                } else if (s.charAt(2) != '0' && s.charAt(1) <= '1' && s.charAt(0) == '2') {
                    s.clear();
                } else if (s.charAt(3) != '0' && s.charAt(0) == '2') {
                    s.clear();
                }
            }
            else if(s.length()>4){
                s.replace(3,4,"");
            }
        }
    };

    @Override
    public void onOtherFragment(long id) {
        mListener.aboutFragment(id);
    }

    public interface OnFragmentInteractionListener {
        void aboutFragment(long id);
    }
}
