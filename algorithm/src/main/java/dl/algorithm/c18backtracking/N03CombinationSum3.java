package dl.algorithm.c18backtracking;

import java.util.ArrayList;
import java.util.List;

public class N03CombinationSum3 {
    final List<List<Integer>> ans = new ArrayList<>();
    final List<Integer> path = new ArrayList<>();
    int cnt;
    int target;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.target = n;
        this.cnt = k;
        backtracking(1);
        return ans;
    }

    private void backtracking(int startIndex) {
        if (target < 0 || startIndex == 10) return;
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < 10; i++) {
            target -= i;
            path.add(i);
            backtracking(i + 1);
            path.remove(path.size() - 1);
            target += i;
        }
    }
}
