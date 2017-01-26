package test;

import code.FlightMovies;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightMoviesTest {
    @Test
    public void expect_true() {
        int[] movieTimes = {30, 60, 55, 70, 90};
        int flightTime = 100;

        FlightMovies tester = new FlightMovies(movieTimes);
        assertEquals(true, tester.watchTwo(flightTime));
    }

    @Test
    public void expect_false() {
        int[] movieTimes = {35, 60, 55, 70, 90};
        int flightTime = 100;

        FlightMovies tester = new FlightMovies(movieTimes);
        assertEquals(false, tester.watchTwo(flightTime));
    }
}
