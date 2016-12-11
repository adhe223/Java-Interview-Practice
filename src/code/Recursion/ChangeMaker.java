package code.Recursion;

public class ChangeMaker {
    private int[] denoms;
    private int combos = 0;

    public ChangeMaker(int[] denoms) {
        this.denoms = denoms;
    }

    public int makeChangeEntry(int remaining, int denom) {
        makeChange(remaining, denom);
        return combos;
    }

    private void makeChange(int remaining, int denom) {
        // Base Case
        if (remaining == 0) {
            combos++;
            return;
        }

        // Safety
        if (denom >= denoms.length) {
            return;
        }

        for (int i = 0; (remaining - (i * denoms[denom])) >= 0; i++) {
            makeChange(remaining - (i * denoms[denom]), denom + 1);
        }
    }
}
