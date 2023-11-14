package dl.algorithm.c06binarytree;

public class InOrderSuccessor {

    private TreeNode ans = null;
    private boolean flag = false;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inOrder(root, p.val);
        return ans;
    }

    private void inOrder(TreeNode root, int val) {
        if (root == null) return;
        inOrder(root.left, val);
        if (flag && ans==null) {
            ans = root;
        }
        if (root.val == val) {
            flag = true;
        }
        inOrder(root.right,val);
    }

}
