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

// union find
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < uf.r; i++) {
            for (int j = 0; j < uf.c; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                //below
                if (i + 1 <  uf.r && grid[i + 1][j] == 1) {
                    uf.union(uf.posToIndex(i, j), uf.posToIndex(i + 1, j));
                }
                //right
                if (j + 1 <  uf.c && grid[i][j + 1] == 1) {
                    uf.union(uf.posToIndex(i, j), uf.posToIndex(i, j + 1));
                }
            }
        } 
        return uf.max;
        

    }

    public class UnionFind {
        int[][] grid;
        private int[] fatherCnt;// how many position has the same father
        int max;// max area
        private int[] father; // father of each position
        int r;
        int c;
        UnionFind (int[][] grid) {
            this.grid = grid;
            
            max = 0;
            r = grid.length;
            c = grid[0].length;
            fatherCnt = new int[r * c];// how many position have this index as father
            father = new int[r * c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    int index = posToIndex(i, j);
                    // System.out.println(i + " " + j + " " + index + " " + fatherCnt.length);
                    if (grid[i][j] == 0) {
                        father[index] = -1;
                    } else {
                        fatherCnt[index]++;
                        max = Math.max(max, fatherCnt[index]);
                        father[index] = index;
                    }
                }
            }
        }

        public int find(int index) {
            if (father[index] == index) {
                return index;
            }
            father[index] = find(father[index]);
            return father[index];
        }

        public void union (int index1, int index2) {
            int father1 = find(index1);
            int father2 = find(index2);
            if (father1 != father2) {
                father[father1] = father2;
                // System.out.println(father1 + "  " + father2 + " " + fatherCnt[father1] + "  " + fatherCnt[father2]);
                fatherCnt[father2] += fatherCnt[father1];
                max = Math.max(max, fatherCnt[father2]);
            }
        }

        public int posToIndex(int i, int j) {
            return i * c + j;
        }
    }
}

// bfs
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int max = 0;
        int[] moveI = new int[]{1, -1, 0, 0};
        int[] moveJ = new int[]{0, 0, 1, -1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    Queue<Pos> q = new LinkedList<>();
                    q.offer(new Pos(i,j));
                    grid[i][j] = 2;
                    int curCnt = 0;
                    while (!q.isEmpty()) {
                        Pos cur = q.poll();
                        curCnt++;
                        max = Math.max(max, curCnt);
                        for (int d = 0; d < moveI.length; d++) {
                            Pos next = new Pos(cur.m + moveI[d], cur.n + moveJ[d]);
                            if (check(next, grid)) {
                                q.offer(next);
                                grid[next.m][next.n] = 2;
                            }
                        }
                    }
                }
            }
        }
        return max;
    }
    private boolean check(Pos next, int[][] grid) {
        int m = next.m;
        int n = next.n;
        if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length || grid[m][n] != 1 ) {
            return false;
        }
        return true;
    }
    public class Pos {
        int m;
        int n;
        Pos(int m, int n) {
            this.m = m;
            this.n = n;
        }
    }
}