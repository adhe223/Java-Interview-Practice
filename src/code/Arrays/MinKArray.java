package code.Arrays;

import java.util.PriorityQueue;

public class MinKArray {
    public int[] getMinKArray(int[] A, int k) {
        int[] B = new int[A.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Create the first min heap
        for (int i = 0; i <= k; i++) {
            minHeap.add(A[i]);
        }
        B[0] = minHeap.peek();

        for (int i = 1; i < A.length; i++) {
            // Remove the number that was previously the front of the sliding range
            minHeap.remove(A[i - 1]);

            // Add the last number in range now
            if (i + k < A.length) {
                minHeap.add(A[i + k]);
            }

            B[i] = minHeap.peek();
        }

        return B;
    }
}
