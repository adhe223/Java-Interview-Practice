package test;

import code.NumberToBinary;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class NumberToBinaryTest {
    @Test
    public void validate_wholeNumber() {
        NumberToBinary tester = new NumberToBinary();
        assertEquals("1100", tester.convert(12));
    }
}
