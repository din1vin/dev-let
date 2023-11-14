package dl.algorithm.c03binarysearch;

import java.util.Random;

public class PickIndex {
    private Random random = new Random();
    private int[] sum;

    public PickIndex(int[] w) {
        this.sum = w;
        for (int i = 1; i < w.length; i++) {
            sum[i] += sum[i - 1];
        }
    }

    public int pickIndex() {
        int find = random.nextInt(sum[sum.length - 1]);
        return binarySearch(find);
    }

    private int binarySearch(int x) {
        int i = 0, j = sum.length - 1;
        while (i < j) {
            int mid = (i + j) >>> 1;
            if (sum[mid] < x) {
                i = mid + 1;
            } else {
                j = mid;
            }

        }
        return i;
    }
}
