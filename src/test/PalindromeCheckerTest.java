package test;

import code.Strings.PalindromeChecker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeCheckerTest {
    @Test
    public void validate_true() {
        String test = "iivcc";
        PalindromeChecker tester = new PalindromeChecker();

        assertEquals(true, tester.containsPalindrome(test));
    }

    @Test
    public void validate_false() {
        String test = "iivic";
        PalindromeChecker tester = new PalindromeChecker();

        assertEquals(false, tester.containsPalindrome(test));
    }
}
