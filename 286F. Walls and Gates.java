/**
 * 1. put all the gate  in queue first
 * 2. no need to use step, just use prev + 1
 * 3. it's gaurantee that the shortest path will reach that cell first, 
 * so just use visited to ensure each cell is only visited once
 * no need to compare values for different path
 */
class Solution {
    public void wallsAndGates(int[][] rooms) {
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        helper(rooms, q, visited);
    }
    
    private void helper(int[][] rooms, Queue<int[]> q, boolean[][] visited) {
        int[] moveI = new int[]{1, -1, 0, 0};
        int[] moveJ = new int[]{0, 0, 1, -1};
        while(!q.isEmpty()) {            
            for (int size = q.size(); size > 0; size--) {
                int[] cur = q.poll();

                for (int m = 0; m < moveI.length; m++) {
                    int nextI = cur[0] + moveI[m];
                    int nextJ = cur[1] + moveJ[m];
                    if (valid(rooms, visited, nextI, nextJ) ) {
                        q.offer(new int[]{nextI, nextJ});
                        rooms[nextI][nextJ] = rooms[cur[0]][cur[1]] + 1;
                        visited[nextI][nextJ] = true;
                    }
                }
            }

        }
    }
    
    private boolean valid(int[][] rooms, boolean[][] visited, int nextI, int nextJ) {
        if (nextI < 0 || nextI >= rooms.length || nextJ < 0 || nextJ >= rooms[0].length || visited[nextI][nextJ] || rooms[nextI][nextJ] == -1 || rooms[nextI][nextJ] == 0) {
            return false;
        } 
        return true;
    }
}