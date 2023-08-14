package dl.algorithm.c13queue;

import dl.algorithm.c06binarytree.TreeNode;

import java.util.*;

public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                levelMax = Math.max(cur.val, levelMax);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(levelMax);
        }
        return res;
    }
}
