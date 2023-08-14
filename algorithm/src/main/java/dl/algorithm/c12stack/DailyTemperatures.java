package dl.algorithm.c12stack;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int l = temperatures.length;
        int[] ans = new int[l];
        Stack<int[]> incrDays = new Stack<>();
        for (int i = 0; i < l; i++) {
            while (!incrDays.isEmpty()) {
                if (temperatures[i] <= incrDays.peek()[1]) {
                    break;
                } else {
                    int[] ele = incrDays.pop();
                    ans[ele[0]] = i - ele[0];
                }
            }
            incrDays.push(new int[]{i, temperatures[i]});
        }
        return ans;
    }
}
