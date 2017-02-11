package test;

import code.Arrays.MissingShipmentId;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MissingShipmentIdTest {
    @Test
    public void validate_set() {
        int[] ids = {1,3,1,4,3,2,4};
        MissingShipmentId tester = new MissingShipmentId(ids);

        assertEquals(2, (int)tester.findMissingConfirmation());
    }

    @Test
    public void validate_set_bitwise() {
        int[] ids = {1,3,1,4,3,2,4};
        MissingShipmentId tester = new MissingShipmentId(ids);

        assertEquals(2, (int)tester.findMissingConfirmationBitwise());
    }
}
