package test;

import code.CondenseRanges;
import code.Helpers.Tuple;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CondenseRangesTest {
    @Test
    public void validate_allPos() {
        ArrayList<Tuple> inputs = new ArrayList<>();
        inputs.add(new Tuple(0, 1));
        inputs.add(new Tuple(3, 5));
        inputs.add(new Tuple(4, 8));
        inputs.add(new Tuple(10, 12));
        inputs.add(new Tuple(9, 10));

        CondenseRanges tester = new CondenseRanges();
        String output = tester.condense(inputs);

        assertEquals("(0,1) (3,8) (9,12) ", output);
    }
}
