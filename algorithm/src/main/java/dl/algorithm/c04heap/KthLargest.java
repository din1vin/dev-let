package dl.algorithm.c04heap;

import java.util.PriorityQueue;

public class KthLargest {
    final PriorityQueue<Integer> priorityQueue;
    final int k;

    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            priorityQueue.add(num);
        }
    }

    public int add(int val) {
        priorityQueue.add(val);
        while (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
