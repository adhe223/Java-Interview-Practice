package test;

import code.Strings.ReverseMessage;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ReverseMessageTest {
    @Test
    public void validate_reverseString_even() {
        ReverseMessage tester = new ReverseMessage();
        char[] arr = {'a', 'l', 'e', 'x'};
        char[] result = {'x', 'e', 'l', 'a'};
        assertArrayEquals(result, tester.reverseCharacters(arr, 0, 3));
    }

    @Test
    public void validate_reverseString_odd() {
        ReverseMessage tester = new ReverseMessage();
        char[] arr = {'a', 'l', 'e', 'x', 'a'};
        char[] result = {'a', 'x', 'e', 'l', 'a'};
        assertArrayEquals(result, tester.reverseCharacters(arr, 0, 4));
    }

    @Test
    public void validate_reverseMessage() {
        ReverseMessage tester = new ReverseMessage();
        String str = "alex has cool stuff";

        assertEquals("stuff cool has alex", tester.reverse(str));
    }
}
