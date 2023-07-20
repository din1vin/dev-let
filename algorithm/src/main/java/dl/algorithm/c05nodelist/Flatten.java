package dl.algorithm.c05nodelist;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}

public class Flatten {
    List<Node> list = new ArrayList<>();

    public Node flatten(Node head) {
        dfs(head);
        for (int i = 0, j = 1; j < list.size(); i++, j++) {
            Node pre = list.get(i);
            Node cur = list.get(j);
            cur.prev = pre;
            pre.next = cur;
            pre.child = null;
        }
        return head;
    }

    private void dfs(Node head) {
        if (head == null) return;
        list.add(head);
        dfs(head.child);
        dfs(head.next);
    }

}
