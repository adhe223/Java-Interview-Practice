package test;

import code.CakeThief;
import code.Helpers.CakeType;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CakeThiefTest {
    @Test
    public void standard_test() {
        CakeThief tester = new CakeThief();

        CakeType[] cakeTypes = new CakeType[]{
            new CakeType(7, 160),
            new CakeType(3, 90),
            new CakeType(2, 15)
        };

        int maxValue = tester.maxDuffelBagValue(cakeTypes, 20);
        assertEquals(555, maxValue);
    }
}
