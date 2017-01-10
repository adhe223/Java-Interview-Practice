package code;

import java.util.HashMap;

public class TempTracker {
    private int sum = 0;
    private int low = Integer.MAX_VALUE;
    private int high = Integer.MIN_VALUE;
    private int numTemps = 0;
    private HashMap<Integer, Integer> temps = new HashMap<>();

    private Integer mode;
    private int maxOccurences = 0;

    public void insert(int temp) {
        if (temps.containsKey(temp)) {
            temps.put(temp, temps.get(temp) + 1);
        } else {
            temps.put(temp, 1);
        }

        // Tabulate
        if (temp < low) {
            low = temp;
        }
        if (temp > high) {
            high = temp;
        }
        sum += temp;
        numTemps++;

        int tempOccurences = temps.get(temp);
        if (tempOccurences > maxOccurences) {
            mode = temp;
            maxOccurences = tempOccurences;
        }
    }

    public int getMax() {
        return high;
    }

    public int getMin() {
        return low;
    }

    public Double getMean() {
        return (double)sum / numTemps;
    }

    public Integer getMode() {
        return mode;
    }
}
