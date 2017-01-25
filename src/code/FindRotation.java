package code;

public class FindRotation {
    private String[] words;

    public FindRotation(String[] words) {
        this.words = words;
    }

    public int getRotationIndex() {
        int start = 0;
        int end = this.words.length - 1;

        // 2 or less items in this array
        if (words.length == 0) { return -1; }
        else if (words.length == 1) { return 0; }
        else if (words.length == 2) { return pick2(); }

        // Left side
        while(start <= end) {
            int mid = (start + end) / 2;

            // Get the word to the left
            String left;
            if (mid - 1 >= 0) {
                left = this.words[mid - 1];
            } else {
                // Not on this side
                break;
            }

            // If the word to the left is alphabetically later, this is the rotation point
            if (left.compareTo(this.words[mid]) > 0) {
                return mid;
            }

            // Go left
            end = mid - 1;
        }

        // Right side
        start = 0;
        end = this.words.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            // Get the word to the right
            String right;
            if (mid - 1 >= 0) {
                right = this.words[mid - 1];
            } else {
                return -1;
            }

            // If the word to the left is alphabetically later, this is the rotation point
            if (right.compareTo(this.words[mid]) > 0) {
                return mid;
            }

            // Go right
            start = mid + 1;
        }

        return -1;
    }

    private int pick2() {
        if (this.words[0].compareTo(this.words[1]) > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
