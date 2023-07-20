package dl.algorithm.c05nodelist;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        //快指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 删除slow的下一个节点
        ListNode p = slow.next.next;
        slow.next = p;
        return head;
    }
}
