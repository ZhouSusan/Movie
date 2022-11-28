package Movie;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private int movieId;
    private String title;
    private String genre;
    private String director;
    private int productionYear;
    private double rating;
    private int runTime;
    private String ageRestrictions;
    private List<String> actors;

    public Movie(int movieId, String title, String genre, String director, int productionYear, int rating, int runTime, String ageRestrictions) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.productionYear = productionYear;
        this.rating = rating;
        this.runTime = runTime;
        this.ageRestrictions = ageRestrictions;

        actors = new ArrayList<String>();
    }
}
