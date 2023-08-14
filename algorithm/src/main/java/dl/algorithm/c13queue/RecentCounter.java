package dl.algorithm.c13queue;

import java.util.Deque;
import java.util.LinkedList;

public class RecentCounter {
    private final Deque<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.addLast(t);
        while (t - queue.peekFirst() > 3000) {
            queue.removeFirst();
        }
        return queue.size();
    }
}
