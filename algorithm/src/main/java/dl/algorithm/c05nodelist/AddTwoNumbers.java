package dl.algorithm.c05nodelist;

public class AddTwoNumbers {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        int flag = 0;
        // empty head;
        ListNode head = new ListNode();
        ListNode res = head;
        while (l1 != null & l2 != null) {
            int sum = flag + l1.val + l2.val;
            flag = sum / 10;
            head.next = new ListNode(sum % 10);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remain = l1 == null ? l2 : l1;
        while (flag != 0) {
            if (remain != null) {
                int sum = flag + remain.val;
                flag = sum / 10;
                head.next = new ListNode(sum % 10);
                head = head.next;
                remain = remain.next;
            } else {
                head.next = new ListNode(1);
                break;
            }
        }
        if (remain != null) {
            head.next = remain;
        }
        return res.next;
    }
}
