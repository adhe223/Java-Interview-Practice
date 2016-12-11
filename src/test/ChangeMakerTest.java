package test;

import code.Recursion.ChangeMaker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChangeMakerTest {
    @Test
    public void validate_permutations1_expect4 () {
        int[] denoms = {1, 5, 10};
        ChangeMaker tester = new ChangeMaker(denoms);

        int combinations = tester.makeChangeEntry(10, 0);
        assertEquals(4, combinations);
    }

    @Test
    public void validate_permutations2_expect2 () {
        int[] denoms = {1, 5, 10};
        ChangeMaker tester = new ChangeMaker(denoms);

        int combinations = tester.makeChangeEntry(5, 0);
        assertEquals(2, combinations);
    }

    @Test
    public void validate_permutations3_expect1 () {
        int[] denoms = {1, 5, 10};
        ChangeMaker tester = new ChangeMaker(denoms);

        int combinations = tester.makeChangeEntry(0, 0);
        assertEquals(1, combinations);
    }

    @Test
    public void validate_permutations4_expect0 () {
        int[] denoms = {5, 10};
        ChangeMaker tester = new ChangeMaker(denoms);

        int combinations = tester.makeChangeEntry(1, 0);
        assertEquals(0, combinations);
    }
}
