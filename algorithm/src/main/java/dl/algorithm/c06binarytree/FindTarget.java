package dl.algorithm.c06binarytree;

import java.util.HashSet;

public class FindTarget {
    private HashSet<Integer> numbers = new HashSet<>();
    private boolean ans = false;
    private Integer target;

    public boolean findTarget(TreeNode root, int k) {
        this.target = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        if (numbers.contains(target - node.val)) {
            ans = true;
            return;
        } else {
            numbers.add(node.val);
        }
        dfs(node.left);
        dfs(node.right);
    }
}
