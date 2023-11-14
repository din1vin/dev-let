package dl.algorithm.c06binarytree;

public class ConvertBST {
    int preSum = 0;
    public TreeNode convertBST(TreeNode root) {
        postOrder(root);
        return root;
    }

    private void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.right);
        preSum += root.val;
        root.val = preSum;
        postOrder(root.left);
    }
}
