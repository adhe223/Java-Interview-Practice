package code.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BracketValidator {
    private static final List<Character> openers = Arrays.asList('{', '[', '(');
    private static final List<Character> closers = Arrays.asList('}', ']', ')');
    private Stack<Character> openStack = new Stack<>();

    public boolean validate(String toValidate) {
        for (int i = 0; i < toValidate.length(); i++) {
            char current = toValidate.charAt(i);
            if (!this.processChar(current)) {
                return false;
            }
        }

        return (openStack.size() == 0);
    }

    private boolean processChar(char input) {
        if (openers.contains(input)) {
            this.openStack.push(input);
        } else if (closers.contains(input)) {
            if (openStack.size() == 0) {
                return false;
            }
            char onStack = openStack.pop();
            if (closers.get(openers.indexOf(onStack)) != input) {
                return false;
            }
        }

        return true;
    }
}
