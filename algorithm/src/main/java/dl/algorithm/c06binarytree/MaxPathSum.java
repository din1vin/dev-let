package dl.algorithm.c06binarytree;

public class MaxPathSum {
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        maxContribute(root);
        return ans;
    }

    private int maxContribute(TreeNode root) {
        if (root == null) return 0;
        int leftMax = Math.max(maxContribute(root.left), 0);
        int rightMax = Math.max(0, maxContribute(root.right));
        int priceNewPath = root.val + leftMax + rightMax;
        ans = Math.max(ans, priceNewPath);
        return root.val + Math.max(leftMax, rightMax);
    }
}
