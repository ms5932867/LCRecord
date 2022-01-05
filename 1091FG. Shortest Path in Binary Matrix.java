// Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
// A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
// All the visited cells of the path are 0.
// All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
// The length of a clear path is the number of visited cells of this path.
// Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
// Output: 4
// Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
// Output: -1
class Solution {
    public class Pos {
        int m;
        int n;
        Pos(int m, int n) {
            this.m = m;
            this.n = n;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        
        int step = 1;
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(0,0));
        grid[0][0] = 2;
        int[] mDir = new int[]{1,-1, 0, 0, 1, -1, 1, -1};
        int[] nDir = new int[]{0, 0, 1, -1, 1, -1, -1, 1};

        while (!q.isEmpty()) {
            for (int s = q.size(); s > 0; s--) {
                Pos cur = q.poll();
                if (cur.m == grid.length - 1&& cur.n == grid[0].length - 1) {
                    return step;
                }
                for (int d = 0; d < mDir.length; d++) {
                    Pos next = new Pos(cur.m + mDir[d],cur.n + nDir[d]);
                    if (valid(grid, next)) {
                        grid[next.m][next.n] = 2;
                        q.offer(next);
                    }
                }
            }
            step++;
        }   
        return -1;
    }

    private boolean valid(int[][] grid, Pos p) {
        if (p.m < 0 || p.m >= grid.length || p.n < 0 || p.n >= grid[0].length || grid[p.m][p.n] != 0) {
            return false;
        }
        return true;
    }
}