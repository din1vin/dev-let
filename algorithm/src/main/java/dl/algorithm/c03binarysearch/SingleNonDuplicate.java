package dl.algorithm.c03binarysearch;

public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        // left到right都可能是答案
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            // 相等，说明还没出现单个数，右移
            if (nums[mid] == nums[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
