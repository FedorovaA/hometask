package com.student.movies.model;

public class Movie {
    private int movieNumbers;
    private String movieTitle;
    private String movieYear;
    private String movieMark;
    private String moviePoster;
    private String movieDescription;
    private String movieCountry;
    private String movieAwards;
    private String movieActors;
    private String movieSite;


    public Movie() {
    }

    public Movie(int movieNumbers, String movieTitle, String movieYear, String movieMark, String moviePoster, String movieDescription, String movieCountry, String movieAwards, String movieActors, String movieSite) {
        this.movieNumbers = movieNumbers;
        this.movieTitle = movieTitle;
        this.movieYear = movieYear;
        this.movieMark = movieMark;
        this.moviePoster = moviePoster;
        this.movieDescription = movieDescription;
        this.movieCountry = movieCountry;
        this.movieAwards = movieAwards;
        this.movieActors = movieActors;
        this.movieSite = movieSite;
    }

    public int getMovieNumbers() {
        return movieNumbers;
    }

    public void setMovieNumbers(int movieNumbers) {
        this.movieNumbers = movieNumbers;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieMark() {
        return movieMark;
    }

    public void setMovieMark(String movieMark) {
        this.movieMark = movieMark;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieCountry() {
        return movieCountry;
    }

    public void setMovieCountry(String movieCountry) {
        this.movieCountry = movieCountry;
    }

    public String getMovieAwards() {
        return movieAwards;
    }

    public void setMovieAwards(String movieAwards) {
        this.movieAwards = movieAwards;
    }

    public String getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(String movieActors) {
        this.movieActors = movieActors;
    }

    public String getMovieSite() {
        return movieSite;
    }

    public void setMovieSite(String movieSite) {
        this.movieSite = movieSite;
    }
}
