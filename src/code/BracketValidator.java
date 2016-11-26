package code;

import java.lang.reflect.Array;
import java.util.Stack;

/*
You're working with an intern that keeps coming to you with JavaScript code that won't run because the braces, brackets, and parentheses are off. To save you both some time, you decide to write a braces/brackets/parentheses validator.
Let's say:

'(', '{', '[' are called "openers."
')', '}', ']' are called "closers."
Write an efficient function that tells us whether or not an input string's openers and closers are properly nested.
*/
public class BracketValidator {
    private boolean shortCircuit = false;

    public boolean validate(String str) {
        String result = str;

        if (!this.balanced(str)) {
            return false;
        }

        int start = this.getFirstOpenerPosition(str);
        if (start == -1) { return false; }

        // If the results still has characters then keep going
        while (result.length() > 0) {
            try {
                result = this.iterateAndValidate(result, start);
            } catch (Exception e) {
                return false;
            }
        }

        return result.length() == 0;
    }

    public boolean validateV2(String str) {
        Stack<Character> openers = new Stack<Character>();

        if (!this.balanced(str)) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (this.isOpener(c)) {
                openers.push(c);
            } else if (this.isCloser(c)) {
                if (this.matchingCloser(c, openers.peek())) {
                    openers.pop();
                } else {
                    // An inappropriate closer means this is malformed
                    return false;
                }
            }
        }

        return true;
    }

    // Check if it has the same number of openers as closers
    private boolean balanced(String str) {
        int open = 0;

        for (int i = 0; i < str.length(); i++) {
            if (this.isOpener(str.charAt(i))) {
                open++;
            } else if (this.isCloser(str.charAt(i))) {
                open--;
            }
        }

        return open == 0;
    }

    private String iterateAndValidate(String str, int iOpener) throws Exception {
        char lastOpener = str.charAt(iOpener);

        for (int i = iOpener + 1; i < str.length(); i++) {
            if (this.shortCircuit == true) {throw new Exception("Failure");}

            if (this.isOpener(str.charAt(i))) {
                return this.iterateAndValidate(str, i);
            } else if (this.isCloser(str.charAt(i))) {
                // Does it match?
                if (this.matchingCloser(str.charAt(i), lastOpener)) {
                    // return the string with the section removed
                    return str.substring(0, iOpener) +  str.substring(i + 1);
                } else {
                    // If a closer doesn't match the opener, then it's wrong
                    this.shortCircuit = true;
                    return "@ERROR@";
                }
            }
        }

        // We shouldn't get here
        this.shortCircuit = true;
        return "@ERROR@";
    }

    private boolean isCloser(char c) {
        if (c == '}' || c == ']' || c == ')') {
            return true;
        } else {
            return false;
        }
    }

    private boolean isOpener(char c) {
        if (c == '{' || c == '[' || c == '(') {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean matchingCloser(char c, char lastOpener) {
        if (c == '}' && lastOpener == '{') { return true; }
        else if (c == ']' && lastOpener == '[') { return true; }
        else if (c == ')' && lastOpener == '(') { return true; }

        return false;
    }

    private int getFirstOpenerPosition(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (isOpener(str.charAt(i))) {
                return i;
            }
        }

        return -1;
    }
}
