package dl.algorithm.c18backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 子集II
public class N09SubsetsWithDup {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int[] nums;
    private boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.used = new boolean[nums.length];
        backtracking(0);
        return ans;
    }

    private void backtracking(int startIndex) {
        ans.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking(i + 1);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
