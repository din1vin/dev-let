package dl.algorithm.c07prefixsum;

public class NumMatrix {
    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        sum = new int[row + 1][col + 1];
        for (int r = 1; r <= row; r++) {
            for (int c = 1; c <= col; c++) {
                sum[r][c] = sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1] + matrix[r - 1][c - 1];
            }
        }
    }

    public int sumRegion(int row1,int col1,int row2,int col2){
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1+1][col2] + sum[row1][col1];
    }
}
