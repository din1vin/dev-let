package dl.algorithm.c18backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// N皇后
public class N13SolveNQueens {
    private List<List<String>> ans = new ArrayList<>();
    private boolean[][] chess;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.chess = new boolean[n][n];
        backtracking(0);
        return ans;
    }

    public void backtracking(int row) {
        if (row == n) {
            List<String> collect = Arrays.stream(chess)
                    .map(r -> {
                        StringBuilder sb = new StringBuilder();
                        for (boolean b : r) {
                            String s = b ? "Q" : ".";
                            sb.append(s);
                        }
                        return sb.toString();
                    }).collect(Collectors.toList());
            ans.add(collect);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(row, i)) continue;
            chess[row][i] = true;
            backtracking(row + 1);
            chess[row][i] = false;
        }
    }

    private boolean isValid(int row, int col) {
        // row不能有Q
        for (int i = row; i >= 0; --i) {
            if (chess[i][col]) return false;
        }
        // col 不能有Q
        for (int i = col; i >= 0; --i) {
            if (chess[row][i]) return false;
        }
        // 对角线不能有Q
        for (int i = 1; i <= row; i++) {
            if (col - i >= 0 && chess[row - i][col - i]) {
                return false;
            }
            if (col + i < n && chess[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        solveNQueens(4);
    }
}

