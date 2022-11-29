package Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream  originalContent = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalContent);
    }

    @org.junit.jupiter.api.Test
    void addActorTest() {
        Movie movie1 = new Movie(1, "Twilight", "Sci-Fi", "Paul Smith", 2008, 3.5, 77, "P13");
        movie1.addActor("Bella Smith");
        movie1.addActor("Georgina Ryan");
        movie1.addActor("Test name");

        ArrayList<Movie> movieList = new ArrayList<Movie>();

        assertTrue(movieList.size() == 0);
        assertFalse(movieList.size() == 1);

        //Testing after adding initial element to ArrayList
        movieList.add(movie1);

        assertTrue(movieList.size() == 1);

        //Testing after adding second element to ArrayList

        Movie movie2 = new Movie(1, "Twilight", "Sci-Fi", "Paul Smith", 2008, 3.5, 77, "P13");
        movieList.add(movie2);

        assertTrue(movieList.size() == 2);
    }

    @org.junit.jupiter.api.Test
    void removeActorTest() {
        Movie movie1 = new Movie(1, "Twilight", "Sci-Fi", "Paul Smith", 2008, 3.5, 77, "P13");
        movie1.addActor("Bella Smith");
        movie1.addActor("Georgina Ryan");
        movie1.addActor("Test name");

        Movie movie2 = new Movie(1, "Twilight", "Sci-Fi", "Paul Smith", 2008, 3.5, 77, "P13");
        movie2.addActor("Bella Smith");
        movie2.addActor("Georgina Ryan");
        movie2.addActor("Test name");

        Movie movie3 = new Movie(1, "Twilight Zone", "Sci-Fi", "Ted Mosey", 1990, 4.0, 30, "P13");
        movie3.addActor("Roger from American Dad");
        movie3.addActor("Mario Mario");

        ArrayList<Movie> movieListTest = new ArrayList<Movie> ();
        movieListTest.add(movie1);
        movieListTest.add(movie2);
        movieListTest.add(movie3);

        //arrange
        assertTrue(movieListTest.size() == 3);
        assertFalse(movieListTest.size() == 0);

        movieListTest.remove(movie2);
        assertTrue(movieListTest.size() == 2);

        movieListTest.remove(movie1);
        assertTrue(movieListTest.size() == 1);

        movieListTest.remove(movie3);
        assertTrue(movieListTest.size() == 0);
    }

    @org.junit.jupiter.api.Test
    void displayActorsTest() {

        Movie movie2 = new Movie(1, "Twilight", "Sci-Fi", "Paul Smith", 2008, 3.5, 77, "P13");
        movie2.displayActors();
        movie2.addActor("Bella Smith");
        movie2.addActor("Georgina Ryan");
        movie2.addActor("Test name");

        movie2.displayActors();
        assertEquals("Bella Smith\r\n" +
                "Georgina Ryan\r\n" +
                "Test name", outContent.toString().trim());
    }

    @org.junit.jupiter.api.Test
    void compareToTest() {
        Movie movie1 = new Movie(1, "Twilight", "Sci-Fi", "Paul Smith", 2008, 3.5, 77, "P13");
        movie1.addActor("Bella Smith");
        movie1.addActor("Georgina Ryan");
        movie1.addActor("Test name");

        Movie movie2 = new Movie(1, "Twilight", "Sci-Fi", "Paul Smith", 2008, 3.5, 77, "P13");
        movie2.addActor("Bella Smith");
        movie2.addActor("Georgina Ryan");
        movie2.addActor("Test name");

        Movie movie3 = new Movie(1, "Twilight Zone", "Sci-Fi", "Ted Mosey", 1990, 4.0, 30, "P13");
        movie3.addActor("Roger from American Dad");
        movie3.addActor("Mario Mario");

        assertTrue(movie1.compareTo(movie2) == 0);
        assertFalse(movie3.compareTo(movie2) == 0);
    }

    @org.junit.jupiter.api.Test
    void twoArrayListEqualTest() {

        Movie movie1 = new Movie(1, "Twilight", "Sci-Fi", "Paul Smith", 2008, 3.5, 77, "P13");
        movie1.addActor("Bella Smith");
        movie1.addActor("Georgina Ryan");
        movie1.addActor("Test name");

        Movie movie2 = new Movie(1, "Twilight", "Sci-Fi", "Paul Smith", 2008, 3.5, 77, "P13");
        movie2.addActor("Bella Smith");
        movie2.addActor("Georgina Ryan");
        movie2.addActor("Test name");

        Movie movie3 = new Movie(1, "Twilight Zone", "Sci-Fi", "Ted Mosey", 1990, 4.0, 30, "P13");
        movie3.addActor("Roger from American Dad");
        movie3.addActor("Mario Mario");

        ArrayList<Movie> movieListTest1 = new ArrayList<Movie> ();
        movieListTest1.add(movie1);
        movieListTest1.add(movie2);
        movieListTest1.add(movie3);

        ArrayList<Movie> movieListTest2 = new ArrayList<Movie> ();
        movieListTest2.add(movie1);
        movieListTest2.add(movie2);
        movieListTest2.add(movie3);

        ArrayList<Movie> movieListTest3 = new ArrayList<Movie> ();
        movieListTest3.add(movie1);
        movieListTest3.add(movie3);

        assertEquals(true, Movie.twoArrayListEqual(movieListTest1, movieListTest2));
        assertNotEquals(true, Movie.twoArrayListEqual(movieListTest2, movieListTest3));
    }

    @org.junit.jupiter.api.Test
    void getMovieInfoTest() {
        Movie movie1 = new Movie(1, "Twilight", "Sci-Fi", "Paul Smith", 2008, 3.5, 77, "P13");
        movie1.addActor("Bella Smith");
        movie1.addActor("Georgina Ryan");
        movie1.addActor("Test name");
        String expected = "Title : TwilightGenre: Sci-Fi ,Director: Paul Smith, Year: 2008, Rating3.5Duration Of Movie: Paul Smith\n";
        assertEquals(expected, movie1.getMovieInfo());
    }
}