
// An observation is that,
// if the ball wants to move from i1 to i2,
// we must have the board direction grid[j][i1] == grid[j][i2]

class Solution {
    public int[] findBall(int[][] grid) {
        int[] res = new int[grid[0].length];
        for (int j = 0; j < grid[0].length; j++) {
            res[j] = dfs(grid, 0, j);
        }
        return res;
    }
    private int dfs(int[][] grid, int i, int j){
        if (i == grid.length) {
            return j;
        }
        if ( j + grid[i][j] < 0 || j + grid[i][j] >= grid[0].length || grid[i][j] != grid[i][j + grid[i][j]]) {
            return -1;
        } 
        return dfs(grid, i + 1, j + grid[i][j]);
    }
}