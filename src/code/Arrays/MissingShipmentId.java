package code.Arrays;

import java.util.HashSet;

// If you can modify the passed in ids, and it's a type like an arraylist that you can efficiently remove values,
// you can avoid using an additional data structure.
public class MissingShipmentId {
    private int[] ids;
    private HashSet<Integer> idSet;

    public MissingShipmentId(int[] ids) {
        this.ids = ids;
        this.idSet = new HashSet<>();
        this.populateidSet();
    }

    public Integer findMissingConfirmation() {
        for(int id : this.idSet) {
            return id;
        }

        return null;
    }

    public Integer findMissingConfirmationBitwise() {
        int missingId = 0;

        for (int id : this.ids) {
            missingId ^= id;
        }

        return missingId;
    }

    // The list can't have ids 3 times. So the first time we see it we put it in the hash map, the second time we remove it.
    // That'll leave out hash map with the id that is missing
    private void populateidSet() {
        for (int id : this.ids) {
            boolean contains = this.idSet.contains(id);
            if (contains) {
                this.idSet.remove(id);
            } else {
                this.idSet.add(id);
            }
        }
    }
}