package dl.algorithm.c05nodelist;

class InsertNode {
    public int val;
    public InsertNode next;

    public InsertNode() {
    }

    public InsertNode(int _val) {
        val = _val;
    }

    public InsertNode(int _val, InsertNode _next) {
        val = _val;
        next = _next;
    }
};

public class Insert {
    public InsertNode insert(InsertNode head, int insertVal) {
        InsertNode node = new InsertNode(insertVal);
        if (head == null) {
            head = node;
            head.next = head;
            return head;
        }
        ;
        if (head.next == head) {
            head.next = node;
            head.next.next = head;
            return head;
        }
        InsertNode a = head, b = head.next;
        while (b != head) {
            if ((a.val <= insertVal && insertVal <= b.val)) {
                break;
            }
            if ((a.val <= insertVal || b.val >= insertVal) && a.val > b.val) {
                break;
            }
            a = b;
            b = b.next;
        }
        InsertNode t = node;
        t.next = b;
        a.next = t;
        return head;
    }
}
