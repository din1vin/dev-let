package dl.algorithm.c18backtracking;

import java.util.ArrayList;
import java.util.List;

public class N02CombinationSum {
    final List<List<Integer>> ans = new ArrayList<>();
    final List<Integer> path = new ArrayList<>();
    int pathSum = 0;
    int target;
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;
        backtracking(0);
        return ans;
    }

    public void backtracking(int startIndex) {
        if (pathSum > target) return;
        if (pathSum == target) {
            if (!ans.contains(path)) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex, l = candidates.length; i < l; i++) {
            pathSum += candidates[i];
            path.add(candidates[i]);
            backtracking(i);
            pathSum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

}
