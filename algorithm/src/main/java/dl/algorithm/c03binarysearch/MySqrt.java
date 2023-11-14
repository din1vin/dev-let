package dl.algorithm.c03binarysearch;

public class MySqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int l = 1, r = x / 2;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int s = mid * mid;
            if (s == x) {
                return mid;
            } else if (s > x) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return r;
    }
}
