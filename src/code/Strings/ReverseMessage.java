package code.Strings;

public class ReverseMessage
{
    public String reverse(String message) {
        char[] arr = message.toCharArray();

        // First reverse the characters of the entire string
        this.reverseCharacters(arr, 0, arr.length - 1);

        // Then parse through and reverse each word
        int startWord = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ' && i != 0) {
                // Reverse the characters from startWord to the index before this one
                this.reverseCharacters(arr, startWord, i - 1);
                startWord = i + 1;
            }
        }

        // Once we hit the end we need to reverse the last word
        this.reverseCharacters(arr, startWord, arr.length - 1);

        return new String(arr);
    }

    // Rewrite for practice
    public char[] reverseCharacters(char[] arr, int start, int end) {
        while(start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return arr;
    }
}
