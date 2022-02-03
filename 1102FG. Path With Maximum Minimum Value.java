import java.util.PriorityQueue;
// compare 1102, 778, 1631
class Solution {
    class Pos {
        int m;
        int n;
        int val;
        Pos(int m, int n, int val) {
            this.m = m;
            this.n = n;
            this.val = val;
        }
    }
    int[] dirM = new int[]{1, -1, 0 , 0};
    int[] dirN = new int[]{0 , 0, 1, -1};
    public int maximumMinimumPath(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        PriorityQueue<Pos> pq = new PriorityQueue<>(r, (p1,p2) -> Integer.compare(p2.val, p1.val)); // poll the max val first
        boolean[][] used = new boolean[r][c];
        pq.offer(new Pos(0, 0, grid[0][0]));
        int res = grid[0][0];
        used[0][0] = true;
        
        while(!pq.isEmpty()) {
            Pos cur = pq.poll();
            res = Math.min(res, cur.val);
            if (cur.m == r - 1 && cur.n == c - 1) {
                return res;
            }
            for (int d = 0; d < dirM.length; d++) {
                int nextM = cur.m + dirM[d];
                int nextN = cur.n + dirN[d];
                if (valid(nextM, nextN, used)) {
                    pq.offer(new Pos(nextM, nextN, grid[nextM][nextN]));
                    used[nextM][nextN] = true;

                }
            }
        }
        return res;
    }
    private boolean valid(int nextM, int nextN, boolean[][] used) {
        if (nextM < 0 || nextN < 0 || nextM >= used.length || nextN >= used[0].length || used[nextM][nextN] ) {
            return false;
        }
        return true;
    }
    
}
