package dl.algorithm.c09doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(0) + a.get(1) - b.get(0) - b.get(1));
        for (int x : nums1) {
            for (int y : nums2) {
                pq.offer(Arrays.asList(x, y));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!pq.isEmpty() && k-- > 0) {
            res.add(pq.poll());
        }
        return res;
    }

}
