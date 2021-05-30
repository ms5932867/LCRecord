class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        if (matrix == null || matrix.length == 0) {
            return max;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0'; 
                } else if (matrix[i][j] == '0'){
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
             }
        }
        return max * max;
    }
}