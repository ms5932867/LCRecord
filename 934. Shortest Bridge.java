class Solution {
    class Pos {
        int m;
        int n;
        Pos(int m, int n) {
            this.m = m;
            this.n = n;
        }
    }
    public int shortestBridge(int[][] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        boolean[][] firstIsland = new boolean[A.length][A[0].length];
        
        Queue<Pos> q = new LinkedList<>();
        Queue<Pos> first = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    first.offer(new Pos(i, j));
                    q.offer(new Pos(i, j));
                    firstIsland[i][j] = true;
                    break;
                }
            }
            if (q.size() == 1) {
                break;
            }
        }

        //find the first island
        int[] dirM = new int[]{1, -1, 0, 0};
        int[] dirN = new int[]{0, 0, 1, -1};
        while(!q.isEmpty()) {
            Pos cur = q.poll();
            for (int d = 0; d < 4; d++) {
                Pos next = new Pos(cur.m + dirM[d], cur.n + dirN[d]);
                if (validate(next, firstIsland) && A[next.m][next.n] == 1) {
                    q.offer(next);
                    first.offer(next);
                    firstIsland[next.m][next.n] = true;
                }
            }
        }

        int step = 0;
        while (!first.isEmpty()) {
            for (int s = first.size(); s > 0; s--) {
                Pos cur = first.poll();
                for (int d = 0; d < 4; d++) {
                    Pos next = new Pos(cur.m + dirM[d], cur.n + dirN[d]);
                    if (validate(next, firstIsland)) {
                        if ( A[next.m][next.n] == 0) {
                            first.offer(next);
                            firstIsland[next.m][next.n] = true;
                        }
                        else {
                            return step;
                        }
                        
                    }
                }
            }
            step++;
        }

        return step;
    }

    private boolean validate(Pos p, boolean[][] firstIsland ) {
        if (p.m < 0 || p.m >= firstIsland.length || p.n < 0 || p.n >= firstIsland[0].length || firstIsland[p.m][p.n] == true) {
            return false;
        }
        return true;
    }
}