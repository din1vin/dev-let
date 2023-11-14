package dl.algorithm.c02sort;

import dl.algorithm.c05nodelist.ListNode;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode(0);
        int k = lists.length - 1;
        ListNode node = ans;
        while (k >= 0) {
            int roundMin = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i <=k; i++) {
                // 选出最小值
                if (lists[i].val < roundMin) {
                    minIndex = i;
                    roundMin = lists[i].val;
                }
            }
            // 取出minIndex处的值
            node.next = new ListNode(roundMin);
            node = node.next;
            // 该处链表见底,与第len处交换
            lists[minIndex] = lists[minIndex].next;
            if (lists[minIndex] == null) {
                lists[minIndex] = lists[k];
                lists[k] = null;
                k--;
            }
        }
        return ans.next;
    }
}
