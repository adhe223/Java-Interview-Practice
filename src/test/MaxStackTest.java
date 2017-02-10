package test;

import code.MaxStack;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MaxStackTest {
    @Test
    public void validate_order() {
        MaxStack tester = new MaxStack();
        tester.push(1);
        tester.push(8);
        tester.push(3);
        tester.push(10);

        assertEquals((Integer)10, tester.getMax());

        tester.pop();
        assertEquals((Integer)8, tester.getMax());
        tester.pop();
        assertEquals((Integer)8, tester.getMax());
        tester.pop();
        assertEquals((Integer)1, tester.getMax());
        tester.pop();
        assertEquals(null, tester.getMax());

        tester.push(10);
        tester.push(8);

        assertEquals((Integer)10, tester.getMax());
    }
}
