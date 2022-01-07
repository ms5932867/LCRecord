import java.util.Map;
// https://zxi.mytechroad.com/blog/graph/leetcode-1319-number-of-operations-to-make-network-connected/
// Key point is:
// 1. n Nodes need n-1 edges to form a connected component
// 2. use Union Find or DFS to find all the connected components and the answer is connected components - 1
// 3. why we dont need to set visited[i] = false after dfs here?
class Solution {
    boolean[] visited;
    Map<Integer, Set<Integer>> cnts;
    int[][] connections;
    public int makeConnected(int n, int[][] connections) {
        
        if (connections.length < n - 1) {
            return -1;
        }
        this.connections = connections;
        visited = new boolean[n];
        cnts = buildConnectMap();
        int connectedComponents = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                connectedComponents++;
                visited[i] = true;
                helper(n, i);
            }
        }
        
        return connectedComponents -1;
    }
    private Map<Integer, Set<Integer>> buildConnectMap() {
        Map<Integer, Set<Integer>> cnts = new HashMap<>();
        for (int[] c : connections) {
            cnts.putIfAbsent(c[0], new HashSet<>());
            cnts.get(c[0]).add(c[1]);
            cnts.putIfAbsent(c[1], new HashSet<>());
            cnts.get(c[1]).add(c[0]);
            
        }
        return cnts;
    }
    private void helper(int n, int i) {
        if ( !cnts.containsKey(i)) {
            return;
        }
        // visited[i] = true;
        for (int next : cnts.get(i)) {
            if (!visited[next]) {
                visited[next] = true;
                helper(n, next);
            }
        }
    }
}