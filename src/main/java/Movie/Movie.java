package Movie;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private int movieId;
    private String title;
    private String genre;
    private String director;
    private String releaseDate;
    private double rating;
    private int runTime;
    private List<String> actors;

    public Movie(int movieId, String title, String genre, String director, String releaseDate, int rating, int runTime) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.runTime = runTime;

        actors = new ArrayList<String>();
    }
}
