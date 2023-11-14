package dl.algorithm.c03binarysearch;

import java.util.Arrays;


public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int k = high;
        while (low < high) {
            int speed = (high - low) / 2 + low;
            long time = getTime(piles, speed);
            if (time <= h) {
                k = speed;
                high = speed;
            } else {
                low = speed + 1;
            }
        }
        return k;
    }

    public long getTime(int[] piles, int speed) {
        int ans = 0;
        for (int pile : piles) {
            ans += ((pile + speed - 1) / speed);
        }
        return ans;
    }
}
