package code;

import code.Helpers.CakeType;

import java.util.HashMap;

public class CakeThief {
    private HashMap<Integer, Integer> maxAtCapacity;

    public CakeThief() {
        this.maxAtCapacity = new HashMap<>();
        this.maxAtCapacity.put(-1, 0);
    }

    public int maxDuffelBagValue(CakeType[] cakes, int capacity) {
        for (int currentCapactiy = 0; currentCapactiy <= capacity; currentCapactiy++) {
            int maxAt = 0;
            for (CakeType cake : cakes) {
                int bagValue = 0;

                if (cake.weight <= currentCapactiy) {
                    bagValue += cake.value;
                    bagValue += this.maxAtCapacity.get(currentCapactiy - cake.weight);

                    maxAt = bagValue > maxAt ? bagValue : maxAt;
                }
            }

            this.maxAtCapacity.put(currentCapactiy, maxAt);
        }

        return maxAtCapacity.get(capacity);
    }
}
