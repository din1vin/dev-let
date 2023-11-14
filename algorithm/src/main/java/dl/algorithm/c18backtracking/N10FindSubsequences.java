package dl.algorithm.c18backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N10FindSubsequences {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int[] nums;


    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        backtracking(0);
        return ans;
    }

    private void backtracking(int startIndex) {
        if (path.size() > 1) ans.add(new ArrayList<>(path));
        Set<Integer> used = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (used.contains(nums[i])) continue;
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)) continue;
            path.add(nums[i]);
            used.add(nums[i]);
            backtracking(i + 1);
            path.remove(path.size() - 1);
        }
    }

}
