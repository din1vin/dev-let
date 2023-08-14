package dl.algorithm.c12stack;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> remain = new Stack<>();
        for (int a : asteroids) {
            if (remain.isEmpty() || a > 0 || remain.peek() < 0) {
                remain.push(a);
                continue;
            }
            boolean destroyed = false;
            while (!remain.isEmpty()) {
                int p = remain.pop();
                if(p<0) {
                    remain.push(p);
                    break;
                }
                if (p > -a) {
                    remain.push(p);
                    destroyed = true;
                    break;
                }
                if (p == -a) {
                    destroyed = true;
                    break;
                }
            }
            if (!destroyed) {
                remain.push(a);
            }
        }
        int s = remain.size();
        int[] ans = new int[s];
        for (int i = s; i > 0; --i) {
            ans[i] = remain.pop();
        }
        return ans;
    }
}
