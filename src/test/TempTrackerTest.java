package test;

import code.TempTracker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TempTrackerTest {
    private static boolean setupIsDone = false;
    private TempTracker tester = new TempTracker();

    @Before
    public void setUp() {
        if (setupIsDone) {
            return;
        }

        tester.insert(-5);  // min
        tester.insert(106); // max
        tester.insert(-5);
        tester.insert(35);
        tester.insert(6);
        tester.insert(35);
        tester.insert(35); // mode to be returned
        tester.insert(-5);

        setupIsDone = true;
    }

    @Test
    public void validate_max() {
        assertEquals(106, tester.getMax());
    }

    @Test
    public void validate_min() {
        assertEquals(-5, tester.getMin());
    }

    @Test
    public void validate_mean() {
        assertEquals(25.25, tester.getMean(), 0.001);
    }

    @Test
    public void validate_mode() {
        assertEquals(35, tester.getMode(), 0);
    }
}
