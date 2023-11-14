package dl.algorithm.c16dp;

public class GoodBinaryTree {
    public int goodBinaryTree(int n) {
        if (n % 2 == 0) return 0;
        int l = n / 2;
        int[][] dp = new int[l + 1][2];
        dp[0] = new int[]{1, 1};
        for (int i = 1; i < l + 1; i++) {
            dp[i] = new int[]{dp[i - 1][0] * dp[i - 1][1] % 1_0000_0007, dp[i - 1][1] + 1};
        }
        return dp[l][0];
    }
}
