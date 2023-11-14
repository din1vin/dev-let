package dl.algorithm.c02sort;

import dl.algorithm.c05nodelist.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        return process(head);
    }

    public ListNode process(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode fast = node, slow = node;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        right = process(right);
        ListNode left = process(node);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode ans = new ListNode(0);
        ListNode node = ans;
        while (left != null && right != null) {
            if (left.val < right.val) {
                node.next = new ListNode(left.val);
                left = left.next;
            } else {
                node.next = new ListNode(right.val);
                right = right.next;
            }
            node = node.next;
        }

        if (left != null) node.next = left;
        if (right != null) node.next = right;
        return ans.next;
    }
}
