package dl.algorithm.c02sort.problems;

import dl.algorithm.c02sort.tags.Merge;
import dl.algorithm.c07prefixsum.tags.PrefixSum;

/**
 * 区间和个数
 */
@PrefixSum
@Merge
public class CountRangeSum {
    public int countRangeSum(int[] nums, int low, int high) {
        // 用前缀和数组代替原数组
        long[] sums = new long[nums.length];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = nums[i - 1] + nums[i];
        }
        return process(sums, 0, nums.length - 1, low, high);
    }

    public int process(long[] nums, int l, int r, int low, int high) {
        if (l == r) {
            return nums[l] >= low && nums[l] <= high ? 1 : 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(nums, l, mid, low, high)
                + process(nums, mid + 1, r, low, high)
                + merge(nums, l, r, mid, low, high);
    }

    public int merge(long[] nums, int l, int r, int mid, int low, int high) {
        int count = 0;
        int windowL = l;
        int windowR = l;
        for (int i = mid + 1; i <= r; i++) {
            long min = nums[i] - high;
            long max = nums[i] - low;

            while (windowR <= mid && nums[windowR] <= max) {
                windowR++;
            }
            while (windowL <= mid && nums[windowL] < min) {
                windowL++;
            }
            count += (windowR - windowL);
        }

        long[] help = new long[r - l + 1];
        int i = l, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                help[k++] = nums[i++];
            } else {
                help[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            help[k++] = nums[i++];
        }

        while (j <= r) {
            help[k++] = nums[j++];
        }

        System.arraycopy(help, 0, nums, l + 0, help.length);
        return count;
    }


}
