package com.student.movies.DAO;

import com.student.movies.model.Movie;

import java.util.ArrayList;

public class DataObject {
    private static final DataObject instance = new DataObject();

    public static DataObject getInstance() {
        return instance;
    }

    private Movie movie;

    private ArrayList<Movie> movies;

    public ArrayList<Movie> getMovies() {
        if (movies != null) {
            return movies;
        } else {
            movies = new ArrayList<>();
            movies.add(new Movie(1,
                    "Gladiator",
                    "2000",
                    "8.5",
                            "movie46",
                    "When a Roman general is betrayed and his family murdered by an emperor's corrupt son, he comes to Rome as a gladiator to seek revenge.",
                    "USA",
                    "Won 5 Oscars. Another 53 wins & 101 nominations.",
                    "Russell Crowe, Joaquin Phoenix, Connie Nielsen, Oliver Reed",
                    "http://www.gladiator-thefilm.com"));
            movies.add(new Movie(2,
                    "Memento",
                    "2000",
                    "8.4",
                    "movie47",
                    "A man juggles searching for his wife's murderer and keeping his short-term memory loss from being an obstacle.",
                    "UK",
                    "Nominated for 2 Oscars. Another 55 wins & 55 nominations.",
                    "Guy Pearce, Carrie-Anne Moss, Joe Pantoliano, Mark Boone",
                    "http://www.otnemem.com"));
            movies.add(new Movie(3,
                    "The Prestige",
                    "2006",
                    "8.5",
                    "movie48",
                    "Two stage magicians engage in competitive one-upmanship in an attempt to create the ultimate stage illusion.",
                    "USA",
                    "Nominated for 2 Oscars. Another 5 wins & 36 nominations.",
                    "Hugh Jackman, Christian Bale, Michael Caine, Piper Perabo",
                    "http://touchstone.movies.go.com/index.html?dlink=prestige"));
            movies.add(new Movie(4,
                    "The Lion King",
                    "1994",
                    "8.5",
                    "movie49",
                    "Lion cub and future king Simba searches for his identity. His eagerness to please others and penchant for testing his boundaries sometimes gets him into trouble.",
                    "USA",
                    "Won 2 Oscars. Another 33 wins & 30 nominations.",
                    "Rowan Atkinson, Matthew Broderick, Niketa Calame, Jim Cummings",
                    "http://disney.go.com/lionking/"));
            movies.add(new Movie(5,
                    "Apocalypse Now",
                    "1979",
                    "8.5",
                    "movie50",
                    "During the Vietnam War, Captain Willard is sent on a dangerous mission into Cambodia to assassinate a renegade colonel who has set himself up as a god among a local tribe.",
                    "Russia",
                    "Won 5 Oscars. Another 53 wins & 101 nominations.",
                    "Marlon Brando, Martin Sheen, Robert Duvall, Frederic Forrest",
                    "http://www.gladiator-thefilm.com"));
            return movies;
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    private DataObject() {
    }
}
