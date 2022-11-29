package Movie;

import java.util.*;

public class Movie implements Comparable<Movie> {

    private int movieId;
    private String title;
    private String genre;
    private String director;
    private int productionYear;
    private double rating;
    private int runTime;
    private String ageRestrictions;
    private ArrayList<String> actors;

    public Movie(int movieId, String title, String genre, String director, int productionYear, double rating, int runTime, String ageRestrictions) {
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

    public int getMovie() {
        return this.movieId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getDirector() {
        return this.director;
    }

    public int getProductionYear() {
        return this.productionYear;
    }

    public double getRating() {
        return this.rating;
    }

    public int getRunTime() {
        return this.runTime;
    }

    public String getAgeRestrictions() {
        return this.ageRestrictions;
    }

    public void addActor(String actor) {
        if (!actors.contains(actor)) {
            this.actors.add(actor);
        } else {
            System.out.printf("\nIt appears that %s already exist", actor);
        }
    }

    public void removeActor(String actor) {
        if (actors.contains(actor)) {
            this.actors.remove(actor);
        } else {
            System.out.printf("\nActor does not exist from the list.", actor);
        }
    }

    public void displayActors() {
        for (String actor : actors) {
            System.out.println(actor);
        }
    }

    @Override
    public int compareTo(Movie movie) {
        if (this.actors.size() != movie.actors.size()) {
            return 1;
        }

        Set<String> actorSet = new HashSet<String>();
        for (int i = 0; i < this.actors.size(); i++) {
            if (!actorSet.contains(this.actors.get(i))) {
                actorSet.add(this.actors.get(i));
            }
        }

        for (int j = 0; j < movie.actors.size(); j++) {
            if (!actorSet.contains(movie.actors.get(j))) {
                return 1;
            }
        }

        String titleForMovie1 = this.getTitle().toLowerCase();
        String titleForMovie2 = movie.getTitle().toLowerCase();

        String genreForMovie1 = this.getGenre().toLowerCase();
        String genreForMovie2 = movie.getGenre().toLowerCase();

        String directorForMovie1 = this.getDirector().toLowerCase();
        String directorForMovie2 = movie.getDirector().toLowerCase();

        String yearOfMovie1 = Integer.toString(this.productionYear);
        String yearOfMovie2 = Integer.toString(movie.productionYear);

        String ratingForMovie1 = Integer.toString((int) this.getRating());
        String ratingForMovie2 = Integer.toString((int) movie.getRating());

        String runTimeForMovie1 = Integer.toString(this.getRunTime());
        String runTimeForMovie2 = Integer.toString(movie.getRunTime());

        String ageRestForMovie1 = this.getAgeRestrictions().toLowerCase();
        String ageRestForMovie2 = movie.getAgeRestrictions().toLowerCase();

        if (titleForMovie1.equals(titleForMovie2) && genreForMovie1.equals(genreForMovie2) &&
                directorForMovie1.equals(directorForMovie2) && yearOfMovie1.equals(yearOfMovie2) &&
                ratingForMovie1.equals(ratingForMovie2) && runTimeForMovie1.equals(runTimeForMovie2)
                && ageRestForMovie1.equals(ageRestForMovie2)) {
            return 0;
        } else {
            return 1;
        }
    }

    public static boolean twoArrayListEqual(ArrayList<Movie> list1, ArrayList<Movie> list2) {
        System.out.format("\nList 1's size: %s", list1);
        System.out.format("\nList 2's size: %s", list2);
        if (list1.size() != list2.size()) {
            return false;
        }

        Set<Movie> list1Set = new HashSet<Movie>();
        for (int j = 0; j < list1.size(); j++) {
            if (!list1Set.contains(list1.get(j))) {
                list1Set.add(list1.get(j));
            }
        }

        for(int l = 0; l < list2.size(); l++) {
            if (list1Set.contains(list2.get(l))) {
                list1Set.remove(list2.get(l));
            } else {
                //if the person from list does not exist in list 2, then return alse
                return false;
            }
        }
        return list1Set.size() == 0;
    }

    public String getMovieInfo() {
        return "Title : " + getTitle() + "Genre: " + getGenre() + " ,Director: " + getDirector() + ", Year: " + getProductionYear()
                + ", Rating" + getRating() + "Duration Of Movie: " + getDirector() + "\n";
    }

}
