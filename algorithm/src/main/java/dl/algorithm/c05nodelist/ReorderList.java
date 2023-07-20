package dl.algorithm.c05nodelist;

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode mid = findMid(head);
        ListNode l2 = mid.next;
        mid.next = null;
        ListNode l1 = head;
        l2 = reverseList(l2);
        mergeLists(l1, l2);
    }

    /**
     * 获取链表中点
     */
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 记录下一个
            ListNode temp = curr.next;
            // 翻转当前node
            curr.next = prev;

            // 右移指针
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public void mergeLists(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}
