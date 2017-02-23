package code.Strings;

import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType;

import java.util.HashMap;
import java.util.HashSet;

public class PalindromeChecker {
    public boolean containsPalindrome(String toCheck) {
        HashSet<Character> unmatchedChars = new HashSet<>();

        for (int i = 0; i < toCheck.length(); i++) {
            char current = toCheck.charAt(i);
            if (unmatchedChars.contains(current)) {
                unmatchedChars.remove(current);
            } else {
                unmatchedChars.add(current);
            }
        }

        if (unmatchedChars.size() <= 1) {
            return true;
        }
        return false;
    }
}
