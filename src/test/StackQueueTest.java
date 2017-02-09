package test;

import code.StackQueue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackQueueTest {
    @Test
    public void validate_order() {
        StackQueue<Integer> tester = new StackQueue<>();
        tester.enqueue(1);
        tester.enqueue(2);
        tester.enqueue(3);
        tester.enqueue(4);

        assertEquals(1, (long)tester.dequeue());
        assertEquals(2, (long)tester.dequeue());

        tester.enqueue(5);

        assertEquals(3, (long)tester.dequeue());

        tester.enqueue(6);

        assertEquals(4, (long)tester.dequeue());
        assertEquals(5, (long)tester.dequeue());
        assertEquals(6, (long)tester.dequeue());
    }

    @Test
    public void validate_empty_dequeue() {
        StackQueue<Integer> tester = new StackQueue<>();
        assertEquals(null, tester.dequeue());
    }
}