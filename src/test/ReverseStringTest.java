package test;

import code.Arrays.ReverseString;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseStringTest {
    @Test
    public void validate_even() {
        ReverseString tester = new ReverseString();
        String str = "alex";
        assertEquals("xela", tester.reverse(str));
    }

    @Test
    public void validate_odd() {
        ReverseString tester = new ReverseString();
        String str = "table";
        assertEquals("elbat", tester.reverse(str));
    }
}
