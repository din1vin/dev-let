package dl.algorithm.c18backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//全排列2
public class N12Permute2 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int[] nums;
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking();
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
