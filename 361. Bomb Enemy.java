// Similar to LO DP3: 
// LC 764 https://leetcode.com/problems/largest-plus-sign/
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        
        int[][] up = new int[grid.length][grid[0].length];
        // up
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i - 1][j] == 'E') {
                    up[i][j] = up[i - 1][j] + 1;
                } else if (grid[i - 1][j] == 'W') {
                    up[i][j] = 0;
                } else {
                    up[i][j] = up[i - 1][j];
                }
            }
        }
        // down
        int[][] down = new int[grid.length][grid[0].length];
        for (int i = grid.length - 2; i >= 0; i-- ) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i + 1][j] == 'E') {
                    down[i][j] = down[i + 1][j] + 1;
                } else if (grid[i + 1][j] == 'W') {
                    down[i][j] = 0;
                } else {
                    down[i][j] = down[i + 1][j];
                }
            }
        }
        // left
        int[][] left = new int[grid.length][grid[0].length];
        for (int j = 1; j < grid[0].length; j++ ) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i ][j - 1] == 'E') {
                    left[i][j] = left[i ][j - 1] + 1;
                } else if (grid[i][j - 1] == 'W') {
                    left[i][j] = 0;
                } else {
                    left[i][j] = left[i ][j - 1];
                }
                // System.out.println( i + " " + j + " " + left[i][j]);
            }
            
        }

        // right
        int[][] right = new int[grid.length][grid[0].length];
        for (int j = grid[0].length - 2; j >=0 ; j-- ) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i ][j + 1] == 'E') {
                    right[i][j] = right[i ][j + 1] + 1;
                } else if (grid[i ][j + 1] == 'W') {
                    right[i][j] = 0;
                } else {
                    right[i][j] = right[i ][j + 1];
                }
                // System.out.println( i + " " + j + " " + right[i][j]);
            }
        }

        // cnt
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    int tmp = up[i][j] + down[i][j] + left[i][j] + right[i][j];
                    max = Math.max(max, tmp);
                    // System.out.println( i + " " + j + " " + tmp + " " + left[i][j] + " " + right[i][j]);
                }
                
            }
        }
        return max;


    }
}