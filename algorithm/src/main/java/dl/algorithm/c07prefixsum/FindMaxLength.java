package dl.algorithm.c07prefixsum;

import java.util.HashMap;
import java.util.Map;

public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        int n = nums.length, ans = 0;
        int[] sum = new int[n + 1];
        //初始化前缀和
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }
        // 记录每个前缀和的最小index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0); // 前缀和为0的最小下标是0
        // 遍历前缀和数组
        for (int i = 1; i <= n; i++) {
            int t = sum[i];
            if (map.containsKey(t)) {
                ans = Math.max(ans, t - map.get(t));
            } else {
                map.put(t, i);
            }
        }
        return ans;
    }
}
