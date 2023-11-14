package dl.algorithm.c06binarytree;

import java.util.HashMap;
import java.util.Map;

public class PathSum {
    private Map<Long, Integer> preSumCount = new HashMap<>();
    private int target;

    public int pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        preSumCount.put(0L, 1);
        return dfs(root, 0L);
    }

    private int dfs(TreeNode node, Long curSum) {
        if (node == null) return 0;

        int res = 0;
        curSum += node.val;

        res += preSumCount.getOrDefault(curSum - target, 0);

        preSumCount.put(curSum, preSumCount.getOrDefault(curSum, 0) + 1);
        res += dfs(node.left, curSum);
        res += dfs(node.right, curSum);

        preSumCount.put(curSum, preSumCount.get(curSum) -1);
        return res;
    }
}
