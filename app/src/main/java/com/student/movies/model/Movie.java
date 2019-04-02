package com.student.movies.model;

public class Movie {
    private long movieNumbers;
    private String movieTitle;
    private int movieYear;
    private double movieMark;
    private String moviePoster;
    private String movieDescription;
    private String movieAwards;
    private String movieActors;
    private String movieSite;


    public Movie() {
    }

    public Movie(long movieNumbers, String movieTitle, int movieYear, double movieMark, String moviePoster, String movieDescription) {
        this.movieNumbers = movieNumbers;
        this.movieTitle = movieTitle;
        this.movieYear = movieYear;
        this.movieMark = movieMark;
        this.moviePoster = moviePoster;
        this.movieDescription = movieDescription;
    }

    public Movie(long movieNumbers, String movieTitle, int movieYear, double movieMark, String moviePoster, String movieDescription, String movieAwards, String movieActors, String movieSite) {
        this.movieNumbers = movieNumbers;
        this.movieTitle = movieTitle;
        this.movieYear = movieYear;
        this.movieMark = movieMark;
        this.moviePoster = moviePoster;
        this.movieDescription = movieDescription;
        this.movieAwards = movieAwards;
        this.movieActors = movieActors;
        this.movieSite = movieSite;
    }
    public Movie(String movieTitle, int movieYear, double movieMark, String moviePoster, String movieDescription,  String movieAwards, String movieActors, String movieSite) {
        this.movieTitle = movieTitle;
        this.movieYear = movieYear;
        this.movieMark = movieMark;
        this.moviePoster = moviePoster;
        this.movieDescription = movieDescription;
        this.movieAwards = movieAwards;
        this.movieActors = movieActors;
        this.movieSite = movieSite;
    }


    public long getMovieNumbers() {
        return movieNumbers;
    }

    public void setMovieNumbers(long movieNumbers) {
        this.movieNumbers = movieNumbers;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public double getMovieMark() {
        return movieMark;
    }

    public void setMovieMark(double movieMark) {
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
