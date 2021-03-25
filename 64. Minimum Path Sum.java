class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        int[][] res = new int[grid.length][grid[0].length];
        res[0][0] = grid[0][0];
        for (int i = 1; i < res[0].length; i++) {
            res[0][i] = res[0][i - 1] + grid[0][i];
        }
        for (int j = 1; j < res.length; j++) {
            res[j][0] = res[j - 1][0] + grid[j][0];
        }
        for (int i = 1; i < res.length; i++) {
            for (int j = 1; j < res[0].length; j++) {
                res[i][j] =  Math.min(res[i][j - 1] , res[i - 1][j]) + grid[i][j];
            }
        }
        return res[res.length - 1][res[0].length - 1];
    }
}