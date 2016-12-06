package code;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Highest3Ints {
    private int[] mostNeg = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    private int[] mostPos = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
    private int posSet = 0;

    public int highestProduct(int[] arr) throws Exception {
        if (arr.length < 3) { throw new Exception("Trash array!"); }

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];

            if (mostPos[0] < val) {
                mostPos[2] = mostPos[1];
                mostPos[1] = mostPos[0];
                mostPos[0] = val;
                posSet++;
            } else if (mostPos[1] < val) {
                mostPos[2] = mostPos[1];
                mostPos[1] = val;
                posSet++;
            } else if (mostPos[2] < val) {
                mostPos[2] = val;
                posSet++;
            }

            if (val < 0) {
                if (mostNeg[0] > val) {
                    mostNeg[1] = mostNeg[0];
                    mostNeg[0] = val;
                } else if (mostNeg[1] > val) {
                    mostNeg[1] = val;
                }
            }
        }

        if (mostNeg.length < 2) { return getSum(mostPos); }
        return (getSum(mostNeg) * mostPos[0] > getSum(mostPos) ?
                getSum(mostNeg) * mostPos[0] :
                getSum(mostPos));
    }

    private int getSum(int[] a) {
        int product = 1;
        for (int i = 0; i < a.length; i++) {
            product *= a[i];
        }
        return product;
    }
}
