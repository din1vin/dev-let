package dl.algorithm.c18backtracking;

import java.util.ArrayList;
import java.util.List;

public class N01Combine {
    final List<List<Integer>> ans = new ArrayList<>();
    final List<Integer> path = new ArrayList<>();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backTracking(1);
        return ans;
    }

    private void backTracking(int i) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int x = i; x <= n; x++) {
            if (path.size() + (n - x + 1) < k) {
                continue;
            }
            path.add(x);
            backTracking(x + 1);
            path.remove(path.size() - 1);
        }
    }
}
