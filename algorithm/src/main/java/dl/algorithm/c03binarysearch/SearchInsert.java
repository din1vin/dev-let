package dl.algorithm.c03binarysearch;

import org.junit.Test;

import java.util.Arrays;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int ans = Arrays.binarySearch(nums, target);
        return ans > 0 ? ans : -ans - 1;
    }
}
