package dl.algorithm.c05nodelist;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public InsertNode prev;
    public InsertNode next;
    public InsertNode child;
}

public class Flatten {
    List<InsertNode> list = new ArrayList<>();

    public InsertNode flatten(InsertNode head) {
        dfs(head);
        for (int i = 0, j = 1; j < list.size(); i++, j++) {
            InsertNode pre = list.get(i);
            InsertNode cur = list.get(j);
            cur.prev = pre;
            pre.next = cur;
            pre.child = null;
        }
        return head;
    }

    private void dfs(InsertNode head) {
        if (head == null) return;
        list.add(head);
        dfs(head.child);
        dfs(head.next);
    }

}
