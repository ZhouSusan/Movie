package Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieApp {
    public static void main(String[] args) {
        ArrayList<Movie> movieList1 = new ArrayList<Movie>();
        ArrayList<Movie> movieList2 = new ArrayList<Movie>();

        Movie movie1 = new Movie(1, "Twilight", "Sci-Fi", "Paul Smith", 2008, 3.5, 77, "P13");
        movie1.addActor("Bella Smith");
        movie1.addActor("Georgina Ryan");
        movie1.addActor("Test name");
        movie1.addActor("Test namer");


        System.out.println(movie1.getMovieInfo());
        movie1.displayActors();
        movie1.removeActor("Test name");
        System.out.println("______________________________________________________________________");

        Movie movie2 = new Movie(1, "Twilight", "Sci-Fi", "Paul Smith", 2008, 3.5, 77, "P13");
        movie1.displayActors();
        movie2.addActor("Bella Smith");
        movie2.addActor("Georgina Ryan");
        movie2.addActor("Test name");
        System.out.println(movie1.compareTo(movie2) == 0);
        System.out.println(movie2.getMovieInfo());
        movie2.displayActors();

        System.out.println("______________________________________________________________________");
        movieList1.add(movie1);
        movieList1.add(movie2);
        movieList2.add(movie1);
        movieList2.add(movie1);
        movieList2.add(movie2);

        System.out.println(Movie.twoArrayListEqual(movieList1, movieList2));
    }
}
