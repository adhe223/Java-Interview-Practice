package test;

import code.ParenthesisMatch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParenthesisMatchTest {
    @Test
    public void validate_match() {
        String test = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
        ParenthesisMatch tester = new ParenthesisMatch();

        assertEquals(79, tester.matchingParen(test, 10));
    }

    @Test
    public void validate_noMatch() {
        String test = "Sometimes (when I nest them (my parentheticals) too much (like this (and this)) they get confusing.";
        ParenthesisMatch tester = new ParenthesisMatch();

        assertEquals(-1, tester.matchingParen(test, 10));
    }
}
