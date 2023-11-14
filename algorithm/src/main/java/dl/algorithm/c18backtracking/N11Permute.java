package dl.algorithm.c18backtracking;

import java.util.ArrayList;
import java.util.List;

// 全排列
public class N11Permute {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int[] nums;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.used = new boolean[nums.length];
        backtracking();
        return ans;
    }

    public void backtracking() {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking();
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
