package dl.algorithm.c07prefixsum;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        // 初始化前缀和数组
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i < n; i++) {
            if(sum[i-1] == sum[n] - sum[i+1]){
                return i;
            }
        }
        return -1;
    }
}
