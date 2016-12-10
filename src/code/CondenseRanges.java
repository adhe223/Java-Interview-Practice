package code;
import code.Helpers.Tuple;
import java.util.ArrayList;
import java.util.HashMap;

public class CondenseRanges {
    private int lowest = Integer.MAX_VALUE;
    private int highest = -1;
    private HashMap<Integer, Integer> booked = new HashMap<>();  //TODO: Use a bitmap to save space

    // Booked Integer Key:
    // 0: Start of meeting
    // 1: During
    // 2: End of meeting
    // 3: Start and end of meetings

    public String condense(ArrayList<Tuple> inputs) {
        inputToMap(inputs);
        if (lowest == Integer.MAX_VALUE || highest == -1) { return "Boooooo!"; }

        // Loop from the lowest to the highest and check if they are booked. Keeping track of the previous time that
        // is booked.

        StringBuilder sb = new StringBuilder();
        int mostRecentStart = lowest;
        int mostRecentEnd = -1;
        boolean streak = true;

        for (int i = lowest + 1; i <= highest; i++) {
            if (booked.containsKey(i)) {
                // We have the value, is it the end, beginning, or middle, or transition?
                if (booked.get(i) == 0) {
                    // Beginning
                    mostRecentStart = i;
                } else if (booked.get(i) == 2) {
                    // End of meeting, we don't count this for merging
                    mostRecentEnd = i;
                    sb.append("(" + mostRecentStart + "," + mostRecentEnd + ") ");
                }
            }
        }

        return sb.toString();
    }

    // Populate our internal data structures
    private void inputToMap(ArrayList<Tuple> inputs) {
        for (int i = 0; i < inputs.size(); i++) {
            int first = inputs.get(i).getFirst();
            int second = inputs.get(i).getSecond();

            if (second < first) {
                first = second;
                second = first;
            }

            // Store highest and lowest values
            if (first < lowest) { lowest = first; }
            if (second > highest) { highest = second; }

            mapInsert(first, 0);
            mapInsert(second, 2);

            // Populate the booked array with the times of the meetings
            for (int j = first + 1; j < second; j++) {
                mapInsert(j, 1);
            }
        }
    }

    private void mapInsert(int index, int value) {
        if (booked.containsKey(index)) {
            // If it's a during, we can leave it.
            // If it's an end, we instert our value.
            // If it's a beginning and we're putting a during or end, we overwrite with during
            if (booked.get(index) == 2) {
                booked.put(index, value);
            } else if (booked.get(index) == 0 && (value == 1 || value == 2)) {
                booked.put(index, 1);
            }
        } else {
            booked.put(index, value);
        }
    }
}
