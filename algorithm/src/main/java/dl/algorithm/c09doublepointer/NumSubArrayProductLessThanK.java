package dl.algorithm.c09doublepointer;

public class NumSubArrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int n = nums.length, ans = 0, prod = 1, left = 0;
        for (int right = 0; right < n; ++right) {
            prod *= nums[right];
            while (prod >= k) // 不满足要求
                prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
}
