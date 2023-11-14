package dl.algorithm.c17greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SoldiersDown {
    public int soldiersDown(int[] positions, int[] heights) {
        int l = positions.length;
        if (l == 1) return 1;
        // 第一个士兵往左倒
        int watermark = positions[0];
        // 最少有两个士兵可以倒
        int ans = 2;
        for (int i = 1; i < l - 1; i++) {
            // 能往左倒
            if (positions[i] - heights[i] > watermark) {
                ans++;
                watermark = positions[i];
            }
            // 往右倒
            else if (positions[i] + heights[i] < positions[i + 1]) {
                ans++;
                watermark = positions[i] + heights[i];
            }
            // 不能倒
            else {
                watermark = positions[i];
            }
        }
        return ans;
    }


    @Test
    public void test() {
        int[] positions = new int[]{15, 42, 45, 51, 94};
        int[] heights = new int[]{37, 12, 7, 34, 33};
        assertEquals(4,soldiersDown(positions, heights));
    }
}
