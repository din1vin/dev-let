package dl.algorithm.c18backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N05CombinationSum2 {
    final List<List<Integer>> ans = new ArrayList<>();
    final List<Integer> path = new ArrayList<>();
    int pathSum = 0;
    int target;
    int[] candidates;
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;
        this.used = new boolean[candidates.length];
        Arrays.sort(this.candidates);
        backtracking(0);
        return ans;
    }

    public void backtracking(int startIndex) {
        if (pathSum > target) return;
        if (pathSum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex, l = candidates.length; i < l; i++) {
            if(i>0 && candidates[i] == candidates[i-1] && !used[i]) continue;
            pathSum += candidates[i];
            used[i] = true;
            path.add(candidates[i]);
            backtracking(i + 1);
            pathSum -= candidates[i];
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
