package com.student.movies.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class MovieData {
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("year")
    @Expose
    private int year;
    @SerializedName("actors")
    @Expose
    private String actors;
    @SerializedName("plot")
    @Expose
    private String description;
    @SerializedName("awards")
    @Expose
    private String awards;
    @SerializedName("poster")
    @Expose
    private String poster;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("rate")
    @Expose
    private double rate;

    public MovieData() {
    }

    public MovieData(Long id, String title, int year, String actors, String description, String awards, String poster, String website, double rate) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.actors = actors;
        this.description = description;
        this.awards = awards;
        this.poster = poster;
        this.website = website;
        this.rate = rate;
    }

    public MovieData(Long id, String title, int year, String description, String poster, double rate) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.description = description;
        this.poster = poster;
        this.rate = rate;
    }

    public MovieData(String title, int year, String actors, String description, String awards, String poster, String website, double rate) {
        this.title = title;
        this.year = year;
        this.actors = actors;
        this.description = description;
        this.awards = awards;
        this.poster = poster;
        this.website = website;
        this.rate = rate;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
