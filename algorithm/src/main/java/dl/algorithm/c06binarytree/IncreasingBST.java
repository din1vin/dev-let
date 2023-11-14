package dl.algorithm.c06binarytree;

public class IncreasingBST {
    private TreeNode pre = null;
    private TreeNode ans = null;

    public TreeNode increasingBST(TreeNode root) {
        midOrder(root);
        return ans;
    }

    private void midOrder(TreeNode root) {
        if (root == null) return;
        midOrder(root.left);
        if (pre == null) {
            ans = new TreeNode(root.val);
            pre = ans;
        } else {
            pre.right = new TreeNode(root.val);
            pre = pre.right;
        }
        midOrder(root.right);
    }
}
