package dl.algorithm.c13queue;

import java.util.Deque;
import java.util.LinkedList;

public class MovingAverage {
    private final int size;
    private final Deque<Integer> queue;
    private double sum = 0.0;

    public MovingAverage(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
    }

    public double next(int val) {
        queue.addLast(val);
        sum += val;
        if (queue.size() <= size) {
            return sum / queue.size();
        }
        int first = queue.removeFirst();
        sum -= first;
        return sum / size;
    }
}
