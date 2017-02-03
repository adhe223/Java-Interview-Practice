package code;

import java.util.HashMap;

public class Fibonacci {
    private HashMap <Integer, Integer> fibCache = new HashMap();
    private int n;

    public int fib(int n) {
        this.n = n;
        fibCache.put(0, 0);
        fibCache.put(1, 1);

        if (n == 0 || n == 1) {
            return n;
        }
        else {
            return computeFib(2);
        }
    }

    public int computeFib(int i) {
        int newVal = this.fibCache.get(i - 1) + this.fibCache.get(i - 2);

        if (i == n) {
            // We want!
            return newVal;
        }

        fibCache.put(i, newVal);
        return computeFib(i + 1);
    }

    public int fibIter(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int prevPrev = 0;
        int prev = 1;
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = prevPrev + prev;
            prevPrev = prev;
            prev = current;
        }

        return current;
    }
}
