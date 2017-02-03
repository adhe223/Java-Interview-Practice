package test;

import code.Fibonacci;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {
    @Test
    public void expect_5() {
        Fibonacci tester = new Fibonacci();

        assertEquals(3, tester.fib(4));
    }

    @Test
    public void expect_0() {
        Fibonacci tester = new Fibonacci();

        assertEquals(0, tester.fib(0));
    }

    @Test
    public void iter_expect_5_iter() {
        Fibonacci tester = new Fibonacci();

        assertEquals(3, tester.fibIter(4));
    }

    @Test
    public void iter_expect_0() {
        Fibonacci tester = new Fibonacci();

        assertEquals(0, tester.fibIter(0));
    }
}
