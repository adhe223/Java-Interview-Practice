package code;

import java.util.Stack;

public class NumberToBinary {
    private float toConvert;

    public String convert(int toConvert) {
        int whole = (int) Math.floor(toConvert);
        Stack<Integer> binStack = new Stack<>();
        StringBuilder res = new StringBuilder();

        while (whole > 0) {
            int remainder = whole % 2;
            binStack.push(remainder);
            whole /= 2;
        }

        while (!binStack.isEmpty()) {
            res.append(binStack.pop());
        }

        return res.toString();
    }
}
