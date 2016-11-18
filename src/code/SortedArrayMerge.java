package code;

import java.util.ArrayList;
import java.util.List;

import exceptions.ArraysConsumedException;

/**
 * Created by ahenry on 11/17/16.
 */
public class SortedArrayMerge {
    public int[] merge_lists(int[] arr1, int[] arr2) {
        int[] mergedList = new int[arr1.length + arr2.length];
        int iArr1 = 0;
        int iArr2 = 0;
        int iCombined = 0;

        // Compare the values and merge in
        while (iArr1 < arr1.length && iArr2 < arr2.length) {
            if (arr1[iArr1] < arr2[iArr2]) {
                mergedList[iCombined] = arr1[iArr1];
                iArr1++;
                iCombined++;
            } else {
                mergedList[iCombined] = arr2[iArr2];
                iArr2++;
                iCombined++;
            }
        }

        // Merge in the remaining values in the arrays
        while (iCombined < mergedList.length) {
            if (iArr1 < arr1.length) {
                mergedList[iCombined] = arr1[iArr1];
                iArr1++;
                iCombined++;
            } else {
                mergedList[iCombined] = arr2[iArr2];
                iArr2++;
                iCombined++;
            }
        }

        return mergedList;
    }

    public int[] merge_lists_bonus(List<int[]> arrs) {
        int totalSize = 0;
        int[] combinedArr;
        int iCombined = 0;
        ListInteger li;

        // Initialize the indexList and combined array
        List<Integer> indexList = new ArrayList<Integer>();

        for (int i = 0; i < arrs.size(); i++) {
            indexList.add(0);
            totalSize += arrs.get(i).length;
        }
        combinedArr = new int[totalSize];

        while (true) {
            try {
                li = getLowestCurrentInteger(arrs, indexList);
            } catch (ArraysConsumedException ex) {
                //TODO: This kind of sucks because we are relying on an exception to finish our loop
                return combinedArr;
            }

            // We nee to increment the index of the array that had the lowest value
            indexList.set(li.iList, indexList.get(li.iList) + 1);

            // Push the value onto the combined array
            combinedArr[iCombined] = li.value;
            iCombined++;
        }
    }

    private ListInteger getLowestCurrentInteger(List<int[]> arrList, List<Integer> indexList) throws ArraysConsumedException {
        int value = Integer.MAX_VALUE;
        int iList = -1;

        for (int i = 0; i < arrList.size(); i++) {
            int[] arr = arrList.get(i);
            int index = indexList.get(i);
            int newVal;

            if (index < arr.length) {
                newVal = arr[index];

                // Check if value is initialized
                if (value == Integer.MAX_VALUE) {
                    value = newVal;
                    iList = i;
                } else if (newVal < value) {
                    value = newVal;
                    iList = i;
                }
            }
        }

        // If value is still the max value, then let's throw the exception that all arrays have been consumed
        if (value == Integer.MAX_VALUE) {
            throw new ArraysConsumedException();
        }

        return new ListInteger(iList, value);
    }

    private class ListInteger {
        public final int iList;
        public final int value;

        private ListInteger(int iList, int value) {
            this.iList = iList;
            this.value = value;
        }
    }
}

