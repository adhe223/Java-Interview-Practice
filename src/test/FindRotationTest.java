package test;

import code.FindRotation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindRotationTest {
    @Test
    public void two_elements_expect_1() {
        String[] words = {"hello", "apple"};
        FindRotation tester = new FindRotation(words);

        assertEquals(1, tester.getRotationIndex());
    }

    @Test
    public void five_elements_expect_2() {
        String[] words = {"hello", "iowa", "apple", "beta", "cat"};
        FindRotation tester = new FindRotation(words);

        assertEquals(2, tester.getRotationIndex());
    }
}
