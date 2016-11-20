package code.Strings;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;
import org.junit.experimental.theories.internal.BooleanSupplier;

import java.util.HashMap;
import java.util.stream.Collector;

/*
Given two strings a and b, find whether any anagram of string a is a sub-string of string b. For eg:
if a = xyz and b = afdgzyxksldfm then the program should return true.
*/

public class AnagramSubstring {
    private Boolean containsAnagram = false;
    private String str1;
    private String str2;
    private HashMap<Character, Integer> targetChars = new HashMap<Character, Integer>();

    public AnagramSubstring(String a, String b) {
        this.str1 = a;
        this.str2 = b;
    }

    public Boolean isAnagramSubstringv2(String str1, String str2) {
        // If the length of str2 is less than str1 then it's not possible
        if (str2.length() < str1.length()) {
            return false;
        }

        // Generate the target chars hashmap
        for (int i = 0; i < str1.length(); i++) {
            Character letter = str1.charAt(i);
            Integer count = targetChars.get(letter);

            if (count == null) {
                targetChars.put(letter, 1);
            } else {
                targetChars.put(letter, count + 1);
            }
        }

        // Slide through str2 and see if we can find a series of characters that has the same characters
        for (int i = str2.length() - str1.length(); i >= 0; i--) {
            if (containsCharacters(str2.substring(i, i + str1.length()))) {
                // The substring exists!
                return true;
            }
        }

        return false;
    }

    public Boolean containsCharacters(String str) {
        HashMap<Character, Integer> tempMap = new HashMap<Character, Integer>(this.targetChars);
        System.out.println("containsCharacters of " + str);

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            Integer value = tempMap.get(c);

            if (value == null || value == 0) {
                // This character does not exist in the string
                return false;
            } else {
                // Contains the character, decrement
                tempMap.put(c, value - 1);
            }
        }

        return true;
    }

    public boolean isAnagramSubstring(String str1, String str2) {
        // If the length of str2 is less than str1 then it's not possible
        if (str2.length() < str1.length()) {
            return false;
        }

        // Check if all of the letters in str1 exist in str2
        for (int i = 0; i < str1.length(); i++) {
            if (str2.indexOf(str1.charAt(i)) == -1) {
                return false;
            }
        }

        // We need to check each anagram of the string to see if it exists in str2
        permutationCheck();
        return containsAnagram;
    }

    public void permutationCheck() {
        permutation("", this.str1);
    }

    private void permutation(String prefix, String str) {
        if (str.length() == 0) {
            // Base case, we have a completed anagram
            System.out.println(prefix + " in " + str2);
            if (!this.str2.contains(prefix)) {
                this.containsAnagram = false;
            } else {
                this.containsAnagram = true;
            }
        }
        else {
            for (int i = 0; i < str.length(); i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()));
        }
    }
}
