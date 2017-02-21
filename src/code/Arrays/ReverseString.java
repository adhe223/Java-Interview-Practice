package code.Arrays;

public class ReverseString {
    public String reverse(String str) {
        // Convert the string into an array of chars
        char[] arr = str.toCharArray();

        // Iterate through the array until we get to the middle
        for (int i = 0; i < (arr.length / 2); i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        return new String(arr);
    }
}
