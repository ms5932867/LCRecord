// 这里我们维护一个二维数组dp，其中dp[i][j]表示累计区间(0, 0)到(i, j)这个矩形区间所有的数字之和，
// 那么此时如果我们想要快速求出(r1, c1)到(r2, c2)的矩形区间时，
// 只需dp[r2][c2] - dp[r2][c1 - 1] - dp[r1 - 1][c2] + dp[r1 - 1][c1 - 1]即可
// 下面的代码中我们由于用了辅助列和辅助行，所以下标会有些变化，
// https://www.cnblogs.com/grandyang/p/4958789.html
// time O(1)
class NumMatrix {
    int[][] preSum;
    int r;
    int c;
    public NumMatrix(int[][] matrix) {
        r = matrix.length;
        c = matrix[0].length;
        preSum = new int[r + 1][c + 1];
        
        preSum[0][0] = matrix[0][0];

        for (int i = 0; i < r ; i++) {
            for (int j = 0; j < c ; j++) {
                preSum[i + 1][j + 1] = matrix[i][j] + preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] + preSum[row1 ][col1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */