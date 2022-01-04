// Solution 2: Buildings to Empty land (Better!!!!)
/**
 * During the first BFS we can change the visited empty land values from 0 to -1. 
 * Then during the next BFS we will only visit empty lands with a value of -1s 
 * (meaning they can reach the first house), 
 * then change -1 to -2 and then perform the next BFS only on -2s, and so on...
 */
class Solution {
    private final int EMPTY = 0;
    private final int BUILDING = 1;
    private final int[] moveI = new int[]{1, -1, 0, 0};
    private final int[] moveJ = new int[]{0, 0, 1, -1};
    private int r;
    private int c;
    private int cntBld;
    private int avlbGrid = EMPTY; // Start with 0 , then -1, then -2....
    private int[][] distance;
    private int[][] grid;
    
    public int shortestDistance(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        this.grid = grid;
        this.distance = new int[r][c];
        if (grid == null || r == 0) {
            return 0;
        }
        cntBld = cntBuilding(grid);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == BUILDING) {
                    bfs(i, j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == avlbGrid) {
                    res = Math.min(res, distance[i][j]);
                }
                
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void bfs(int i , int j) {
        boolean[][] visited = new boolean[r][c];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        int step = 1;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) {
                int[] cur = q.poll();
                
                for (int m = 0; m < moveI.length; m++) {
                    int nextI = cur[0] + moveI[m];
                    int nextJ = cur[1] + moveJ[m];
                    if (validate(visited, nextI, nextJ)) {
                        grid[nextI][nextJ]--;
                        distance[nextI][nextJ] += step;
                        q.offer(new int[]{nextI, nextJ});
                        visited[nextI][nextJ] = true;                     
                    }
                }
            }
            step++;
        }
        avlbGrid--;
    }
    private boolean validate( boolean[][] visited, int nextI, int nextJ) {
        if (nextI < 0 || nextI >= r || nextJ < 0 || nextJ >= c || visited[nextI][nextJ] || grid[nextI][nextJ] != avlbGrid) {
                return false;
            }
        return true;
    }

    private int cntBuilding(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == BUILDING) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}




// Solution 1: Empty Land to Houses
// Furthermore, we can be certain that any cell visited during this BFS also 
// cannot reach all of the houses. So we will mark all cells visited during 
// this BFS as obstacles to ensure that we do not start another BFS from this 
// region.
class Solution {
    final int EMPTY = 0;
    final int BUILDING = 1;
    final int OBSTACLE = 2;
    final int[] moveI = new int[]{1, -1, 0, 0};
    final int[] moveJ = new int[]{0, 0, 1, -1};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int cntBld = cntBuilding(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == EMPTY) {
                    int curRes = cntDist(grid, i, j, cntBld);
                    // System.out.println("curRes = " + curRes);
                    res = Math.min(res, curRes);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private int cntDist(int[][] grid, int i, int j, int cntBld) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        int cntDist = 0;
        int step = 1;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) {
                int[] cur = q.poll();
                
                for (int m = 0; m < moveI.length; m++) {
                    int nextI = cur[0] + moveI[m];
                    int nextJ = cur[1] + moveJ[m];
                    // System.out.println("nextI=" + nextI + " nextJ=" + nextJ);
                    if (valid(grid, visited, nextI, nextJ)) {
                         // System.out.println("Valid nextI=" + nextI + " nextJ=" + nextJ);
                        if (grid[nextI][nextJ] == BUILDING) {
                            cntBld--;
                            cntDist += step;
                        } else { // empty
                            q.offer(new int[]{nextI, nextJ});
                            
                        }
                        visited[nextI][nextJ] = true;
                    }
                }
            }
            step++;
        }
        // System.out.println("cntBld=" +cntBld + " cntDist="+cntDist);
        if (cntBld == 0) {
            return cntDist;
        }
        
// Furthermore, we can be certain that any cell visited during this BFS also 
// cannot reach all of the houses. So we will mark all cells visited during 
// this BFS as obstacles to ensure that we do not start another BFS from this 
// region.
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
               if (visited[x][y] && grid[x][y] == EMPTY) {
                   grid[x][y] = OBSTACLE;
               } 
            }
        }
        
        return Integer.MAX_VALUE;
    }
    private boolean valid(int[][] grid, boolean[][] visited, int nextI, int nextJ) {
        if (nextI < 0 || nextI >= grid.length || nextJ < 0 || nextJ >= grid[0].length 
            || visited[nextI][nextJ] || grid[nextI][nextJ] == OBSTACLE) {
                return false;
            }
        return true;
    }
    private int cntBuilding(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == BUILDING) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}


// TLE!!!!
// Furthermore, we can be certain that any cell visited during this BFS also cannot reach all of the houses. So we will mark all cells visited during this BFS as obstacles to ensure that we do not start another BFS from this region.
class Solution {
    final int EMPTY = 0;
    final int BUILDING = 1;
    final int OBSTACLE = 2;
    final int[] moveI = new int[]{1, -1, 0, 0};
    final int[] moveJ = new int[]{0, 0, 1, -1};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int cntBld = cntBuilding(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == EMPTY) {
                    int curRes = cntDist(grid, i, j, cntBld);
                    // System.out.println("curRes = " + curRes);
                    res = Math.min(res, curRes);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private int cntDist(int[][] grid, int i, int j, int cntBld) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        int cntDist = 0;
        int step = 1;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) {
                int[] cur = q.poll();
                
                for (int m = 0; m < moveI.length; m++) {
                    int nextI = cur[0] + moveI[m];
                    int nextJ = cur[1] + moveJ[m];
                    // System.out.println("nextI=" + nextI + " nextJ=" + nextJ);
                    if (valid(grid, visited, nextI, nextJ)) {
                         // System.out.println("Valid nextI=" + nextI + " nextJ=" + nextJ);
                        if (grid[nextI][nextJ] == BUILDING) {
                            cntBld--;
                            cntDist += step;
                        } else { // empty
                            q.offer(new int[]{nextI, nextJ});
                            
                        }
                        visited[nextI][nextJ] = true;
                    }
                }
            }
            step++;
        }
        // System.out.println("cntBld=" +cntBld + " cntDist="+cntDist);
        if (cntBld == 0) {
            return cntDist;
        }
        return Integer.MAX_VALUE;
    }
    private boolean valid(int[][] grid, boolean[][] visited, int nextI, int nextJ) {
        if (nextI < 0 || nextI >= grid.length || nextJ < 0 || nextJ >= grid[0].length 
            || visited[nextI][nextJ] || grid[nextI][nextJ] == OBSTACLE) {
                return false;
            }
        return true;
    }
    private int cntBuilding(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == BUILDING) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}