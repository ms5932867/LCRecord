// compare 1102, 778, 1631
//solution 1: priorityQueue time n^2 * log(n) Space n^2 
class Solution {
    class Pos {
        int m;
        int n;
        Pos(int m, int n) {
            this.m = m;
            this.n = n;
        } 
    }
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pos> pq = new PriorityQueue<>(10, (p1, p2) -> grid[p1.m][p1.n] -grid[p2.m][p2.n]);
        int r = grid.length;
        boolean[][] used = new boolean[r][r];
        pq.offer(new Pos(0, 0));
        int res = grid[0][0];
        used[0][0] = true;
        int[] moveR = new int[]{1, -1, 0, 0};
        int[] moveC = new int[]{0, 0, 1, -1};
        
        while(!pq.isEmpty()) {
            Pos cur = pq.poll();
            res = Math.max(res, grid[cur.m][cur.n]);
            if (cur.m == r - 1 && cur.n == r - 1) {
                return res;
            }
            for (int m = 0; m < moveR.length; m++) {
                Pos next = new Pos(cur.m + moveR[m], cur.n + moveC[m]);
                if (valid(next, used)) {
                    pq.offer(next);
                    used[next.m][next.n] = true;
                }
            }
        }
        return res;
    }
    private boolean valid(Pos p, boolean[][] used) {
        if (p.m < 0 || p.n < 0 || p.m >= used.length || p.n >= used[0].length || used[p.m][p.n]) {
            return false;
        }
        return true;
    }
}
// Solution 2: dfs + binary search time n^2 * log(n) Space n^2 
class Solution {
    class Pos {
        int m;
        int n;
        Pos(int m, int n) {
            this.m = m;
            this.n = n;
        } 
    }
    int[] moveR = new int[]{1, -1, 0, 0};
    int[] moveC = new int[]{0, 0, 1, -1};
    int[][] grid;
    public int swimInWater(int[][] grid) {
        this.grid = grid;
        int r = grid.length;
        int s = Math.max(grid[0][0], grid[r - 1][r - 1]);
        int e = r * r;
        
        boolean[][] used = new boolean[r][r];
        
        while (s + 1 < e) {
            int m = s + (e - s) / 2;
            if (canSwim(m)) {
                e = m;
            } else {
                s = m;
            }
        }
        if (canSwim(s)) {
            return s;
        }
        return e;
        
    }
    private boolean canSwim(int m) {
        boolean[][] used = new boolean[grid.length][grid.length];
        used[0][0] = true;
        dfs( m, used, new Pos(0, 0));
        return used[grid.length - 1][grid.length - 1];
    }
    private void dfs(int m, boolean[][] used, Pos cur) {
        if (cur.m == grid.length - 1 && cur.n == grid.length - 1) {
            return;
        }
        for (int move = 0; move < moveR.length; move++) {
                Pos next = new Pos(cur.m + moveR[move], cur.n + moveC[move]);
                if (valid(next, used, m)) {
                    used[next.m][next.n] = true;
                    dfs(m, used, next);
                }
            }
    }
    
    private boolean valid(Pos p, boolean[][] used, int m) {
        if (p.m < 0 || p.n < 0 || p.m >= used.length || p.n >= used[0].length || used[p.m][p.n] || grid[p.m][p.n] > m) {
            return false;
        }
        return true;
    }
}