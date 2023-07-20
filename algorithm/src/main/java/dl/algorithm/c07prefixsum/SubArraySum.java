package dl.algorithm.c07prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public int subArraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();  // 前缀 -> 出现次数
        map.put(0, 1);  // 以防nums[0]就是k
        int pre = 0, cnt = 0;
        for (int n : nums) {
            pre += n;
            cnt += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return cnt;
    }
}
