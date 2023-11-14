package dl.algorithm.c18backtracking;

import java.util.ArrayList;
import java.util.List;

public class N08Subsets {
    final List<List<Integer>> ans = new ArrayList<>();
    final List<Integer> path = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        backTracking(0);
        return ans;
    }

    public void backTracking(int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 不选i
        backTracking(i + 1);

        // 选i
        path.add(nums[i]);
        backTracking(i + 1);
        path.remove(path.size() - 1);
    }
}
