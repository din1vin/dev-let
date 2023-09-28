package dl.algorithm.c07prefixsum;



public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        if(sum[n-1] - sum[0] == 0) return 0;
        for (int i = 1; i < n - 1; i++) {
            if(sum[i-1] == sum[n-1] - sum[i]) return i;
        }
        if (sum[n - 2] == 0) return n-1;

        return -1;
    }

}
