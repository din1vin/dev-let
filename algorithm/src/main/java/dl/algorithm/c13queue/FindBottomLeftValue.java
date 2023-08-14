package dl.algorithm.c13queue;

import dl.algorithm.c06binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode treeNode) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int res = treeNode.val;
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    res = cur.val;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return res;
    }
}
