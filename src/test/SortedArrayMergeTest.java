package test;
import code.SortedArrayMerge;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class SortedArrayMergeTest {
    @Test
    public void testArrayMerge() {
        int[] arr1 = new int[] {3, 4, 6, 10, 11, 15};
        int[] arr2 = new int[] {1, 5, 8, 12, 14, 19};
        int[] expectedArr = new int[] {1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19};

        SortedArrayMerge tester = new SortedArrayMerge();

        assertArrayEquals(expectedArr, tester.merge_lists(arr1, arr2));
    }

    @Test
    public void testArrayMergeBonus() {
        int[] arr1 = {1, 3, 7};
        int[] arr2 = {4, 5, 6};
        int[] arr3 = {2, 8, 9};

        List<int[]> arrs = new ArrayList<int[]>();
        arrs.add(arr1);
        arrs.add(arr2);
        arrs.add(arr3);

        int[] expectedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        SortedArrayMerge tester = new SortedArrayMerge();
        assertArrayEquals(expectedArr, tester.merge_lists_bonus(arrs));
    }
}
