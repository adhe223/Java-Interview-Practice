package test;

import code.Arrays.MatrixSpiralPrinter;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MatrixSpiralPrinterTest {
    @Test
    public void validate_console() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        MatrixSpiralPrinter tester = new MatrixSpiralPrinter(matrix);
        assertEquals("123698745", tester.print());
    }
}
