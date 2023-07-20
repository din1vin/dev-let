package dl.algorithm.c03binarysearch;

/**
 * @author WuJi
 **/
public class p01_BaseBinarySearch {
    public int search(int[] nums, int target) {
        int r = nums.length - 1, l = 0;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
