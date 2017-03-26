package test;

import code.Arrays.MinKArray;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MinKTest {
    @Test
    public void validate_minKArray() {
        MinKArray tester = new MinKArray();
        int[] results = {2, 2, 1, 0, 0, 0};
        int[] test = {5,2,8,9,1,0};
        assertArrayEquals(results, tester.getMinKArray(test, 2));
    }
}
