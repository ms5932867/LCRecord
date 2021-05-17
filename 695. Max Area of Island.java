class Solution {
    int cur = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    helper(grid, i, j);
                    max = Math.max(cur, max);
                    cur = 0;
                }
            }
        }
        return max;
    }
    private void helper(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 1) {
            return;
        }
        cur++;
        grid[i][j] = 2;
        
        helper(grid, i + 1, j);
        helper(grid, i - 1, j);
        helper(grid, i , j + 1);
        helper(grid, i , j - 1);


    }
}