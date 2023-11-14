package dl.algorithm.c06binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    node.left.val = node.val * 10 + node.left.val;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 10 + node.right.val;
                    queue.offer(node.right);
                }
                if(node.left==null && node.right == null){
                    res += node.val;
                }
            }
        }
        return res;
    }
}
