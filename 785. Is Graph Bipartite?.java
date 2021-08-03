//bfs
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] group  = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (group[i] != 0) {
                continue;
            }
            q.offer(i);
            group[i] = 1;
            while(!q.isEmpty()) {
                
                for (int s = q.size(); s > 0; s--) {
                    int cur = q.poll();
                    for (int next : graph[cur]) {
                        if (group[next] == group[cur]) {
                            return false;
                        } else if (group[next] == group[cur] * (-1)) {
                            continue;
                        } else {
                            group[next] = group[cur] * (-1);
                            q.offer(next);
                        }
                    }
                }
            }
        }
        return true;
    }
}

//dfs
class Solution {
    boolean res = true;
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] != 0) {
                continue;
            }
            color[i] = 1;
            dfs(graph, i, color);
        }
        return res;
    }
    private void dfs(int[][] graph, int i, int[] color) {
        for (int next : graph[i]) {
            if (color[next] == color[i]) {
                res = false;
                return;
            }
            if (color[next] == 0) {
                color[next] = color[i] * (-1);
                dfs(graph, next, color);
            }
            
        }
    }
}

//union find
class Solution {
    public boolean isBipartite(int[][] graph) {
        UnionFind uf = new UnionFind(graph);
        for (int i = 0; i < graph.length; i++) {
            for (int j = 1; j < graph[i].length; j++) {
                uf.union(graph[i][0], graph[i][j]);
            }
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (uf.isConnected(i, graph[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
    public class UnionFind {
        int[][] graph;
        private int[] father;
        UnionFind(int[][] graph) {
            this.graph = graph;
            father = new int[graph.length];
            for (int i = 0; i < father.length; i++) {
                father[i] = i;
            }
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
                father[fatherI] = fatherJ;
            }
        }

        public boolean isConnected(int i, int j) {
            int fatherI = find(i);
            int fatherJ = find(j);
            return fatherI == fatherJ;
        }
        
    }
}