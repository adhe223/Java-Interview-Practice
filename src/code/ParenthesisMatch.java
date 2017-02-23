package code;

public class ParenthesisMatch {
    public int matchingParen(String toSearch, int start) {
        int open = 1;

        for (int i = start + 1; i < toSearch.length(); i++) {
            char current = toSearch.charAt(i);
            if (current == '(') {
                open++;
            } else if (current == ')') {
                open--;
                if (open == 0) {
                    return i;
                }
            }
        }

        return -1;
    }
}
