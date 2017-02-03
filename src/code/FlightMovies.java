package code;

import java.util.HashMap;
import java.util.HashSet;


// TODO: Look at the bonus sections on interview cake problem 14
public class FlightMovies {
    private int[] movieLengths;

    public FlightMovies(int[] movieLengths) {
        this.movieLengths = movieLengths;
    }

    public boolean watchTwo(int flightLength) {
        HashSet<Integer> movieTimes = new HashSet<>();

        // Populate the hashmap as we go
        for (int i = 0; i < this.movieLengths.length; i++) {
            if (movieTimes.contains(flightLength - this.movieLengths[i])) {
                return true;
            } else {
                // Add to movie time hash
                movieTimes.add(this.movieLengths[i]);
            }
        }

        return false;
    }
}
