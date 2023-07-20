package dl.algorithm.c05nodelist;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != null && pB != null) {
            pA = pA.next;
            pB = pB.next;
        }
        ListNode shortP, longP, mark;
        if (pA == null) {
            shortP = headA;
            longP = headB;
            mark = pB;
        } else {
            shortP = headB;
            longP = headA;
            mark = pA;
        }
        while (mark != null) {
            mark = mark.next;
            longP = longP.next;
        }
        while (shortP != longP) {
            shortP = shortP.next;
            longP = longP.next;
        }
        return shortP;
    }
}
