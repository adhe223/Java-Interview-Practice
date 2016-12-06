package test;
import code.Highest3Ints;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Highest3IntsTest {
    @Test
    public void validate_allPos() {
        int[] arr = {1, 6, 9, 2, 0, -2, 4};
        Highest3Ints tester = new Highest3Ints();

        try {
            assertEquals(216, tester.highestProduct(arr));
        } catch (Exception e) {}
    }

    @Test
    public void validate_someNeg() {
        int[] arr = {1, -2, 3, 4, -8};
        Highest3Ints tester = new Highest3Ints();

        try {
            assertEquals(64, tester.highestProduct(arr));
        } catch (Exception e) {}
    }


    @Test
    public void validate_allNeg() {
        int[] arr = {-1, -2, -3, -4, -8};
        Highest3Ints tester = new Highest3Ints();

        try {
            assertEquals(-6, tester.highestProduct(arr));
        } catch (Exception e) {}
    }

    @Test
    public void validate_combo() {
        int[] arr = {-10, -3, -1, 2};
        Highest3Ints tester = new Highest3Ints();

        try {
            assertEquals(60, tester.highestProduct(arr));
        } catch (Exception e) {}
    }

}
