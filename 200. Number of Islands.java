class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '1') {
                    continue;
                }
                // bfs(grid, i, j);
                dfs(grid, i , j);
                cnt++;
            }
        }
        return cnt;
    }
    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '2';
        int[] moveI = new int[]{0, 0, 1, -1};
        int[] moveJ = new int[]{1, -1, 0, 0};
        for (int m = 0; m < 4; m++) {
            int[] next = new int[]{i + moveI[m], j + moveJ[m]};
            if (valid(grid, next)) {
                dfs(grid, next[0], next[1]);
            }
        }
    }
    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        grid[i][j] = '2';
        int[] moveI = new int[]{0, 0, 1, -1};
        int[] moveJ = new int[]{1, -1, 0, 0};
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int m = 0; m < 4; m++) {
                int[] next = new int[]{cur[0] + moveI[m], cur[1] + moveJ[m]};
                if (valid(grid, next)) {
                    q.offer(next);
                    grid[next[0]][next[1]] = 2;
                }
            }
        } 
    }
    private boolean valid(char[][] grid, int[] next) {
        int i = next[0];
        int j = next[1];
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return false;
        }
        return true;
    }
}

// union find
class Solution {
    public int numIslands(char[][] grid) {
        UnionFind uf = new UnionFind(grid);
        
        return uf.cnt;
    }

    public class UnionFind{
        public int cnt;
        public char[][] grid;
        private int m;
        private int n;
        private int[] father;
        UnionFind(char[][] grid) {
            
            this.grid =  grid;
        
            m = grid.length;
            n = grid[0].length;
            cnt = m * n;
            father = new int[m * n];
            for (int i = 0; i < father.length; i++) {
                father[i] = i;
            }
            buildFather();
            
        }

        public int find(int i) {
            if (father[i] == i) {
                return i;
            }
            father[i] = find(father[i]);
            return father[i];
        }

        public void union(int i, int j) {
            int fatherI = find(i);
            int fatherJ = find(j);
            if (fatherI != fatherJ) {
                cnt--;
                father[fatherI] = fatherJ;
            }

        }

        private void buildFather() {
            for (int p = 0; p < m; p++) {
                for (int q = 0; q < n; q++) {
                    if (grid[p][q] == '0') {
                        cnt--;
                    } else { // grid[p][q] = 1
                        //right position (p, q + 1)
                        if (q + 1 < n && grid[p][q + 1] == '1') {
                           
                            union(p * n + q, p * n + q + 1);
                        }

                        //down postion(p + 1, q)
                        if (p + 1 < m && grid[p + 1][q] == '1') {
                            
                            union(p * n + q, (p + 1) * n + q);
                        }

                    }
                }
            }
        }
    }
}