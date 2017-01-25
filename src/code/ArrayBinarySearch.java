package code;

public class ArrayBinarySearch {
    private int[] arr;

    public ArrayBinarySearch(int[] arr) {
        this.arr = arr;
    }

    public int find(int toFind) {
        int start = 0;
        int end = this.arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (toFind == this.arr[mid]) {
                return mid;
            }
            if (toFind < this.arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
