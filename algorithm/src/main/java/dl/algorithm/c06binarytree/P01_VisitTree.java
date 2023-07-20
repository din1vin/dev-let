package dl.algorithm.c06binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 遍历二叉树
 */
@SuppressWarnings("unused")
public class P01_VisitTree {
    /**
     * 先序遍历
     * 根 -> 左 -> 右
     */
    public void preOrderVisit(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrderVisit(root.left);
        preOrderVisit(root.right);
    }

    /**
     * 中序遍历
     * 左 -> 根 -> 右
     */
    public void inOrderVisit(Node root) {
        if (root == null) return;
        inOrderVisit(root.left);
        System.out.print(root.val + " ");
        inOrderVisit(root.right);
    }

    /**
     * 后序遍历
     * 左 -> 右 -> 根
     */
    public void postOrderVisit(Node root) {
        if (root == null) return;
        postOrderVisit(root.left);
        postOrderVisit(root.right);
        System.out.print(root.val + " ");
    }


    /**
     * 前序遍历的无递归实现
     */
    public void preOrderNoRecursion(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur.val + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }


    /**
     * 后序遍历的无递归实现
     */
    public void postOrderNoRecursion(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            Node cur = s1.pop();
            s2.push(cur);
            if (cur.left != null) {
                s1.push(cur.left);
            }
            if (cur.right != null) {
                s1.push(cur.right);
            }
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop().val + " ");
        }
    }

    /**
     * 中序遍历的非递归实现
     */
    public void inOrderNoRecursion(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.print(root.val + " ");
                    root = root.right;
                }
            }
        }
    }

    /**
     * 层序遍历
     */
    public void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                Node node = queue.poll();
                if (node == null) break;
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }
}
