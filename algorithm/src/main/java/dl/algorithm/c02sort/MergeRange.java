package dl.algorithm.c02sort;

import java.util.*;

public class MergeRange {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(x -> x[0]));
        Deque<int[]> stack = new LinkedList<>();
        stack.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] prev = stack.peek();
            if (intervals[i][0] <= prev[1]) {
                stack.pop();
                stack.push(new int[]{prev[0], Math.max(prev[1], intervals[i][1])});
            } else {
                stack.push(intervals[i]);
            }
        }
        return stack.toArray(new int[stack.size()][2]);
    }
}
