package dl.algorithm.c13queue;

import dl.algorithm.c06binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class CBTInserter {
    private TreeNode root;
    private final Queue<TreeNode> candidate;

    public CBTInserter(TreeNode root) {
        this.candidate = new ArrayDeque<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        this.root = root;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (node.left == null || node.right == null) {
                    candidate.offer(node);
                }
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode node = candidate.peek();
        int ret = node.val;
        if (node.left == null) {
            node.left = child;
        } else {
            node.right = child;
            candidate.poll();
        }
        candidate.offer(child);
        return ret;
    }

    public TreeNode get_root(){
        return root;
    }
}
