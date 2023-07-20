package dl.algorithm.c05nodelist;

import java.util.Stack;


public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head.next==null) return true;
        if(head.next.next == null) return head.val==head.next.val;
        Stack<Integer> help = new Stack<>();
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            help.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow.next != null) {
            slow = slow.next;
            if(slow.val!=help.pop()){
                return false;
            }
        }
        return true;
    }
}
