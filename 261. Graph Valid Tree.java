class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length >= n) {
            return false;
        }
        Set<Integer> seen = new HashSet<>();

        List<Set<Integer>> nodeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nodeList.add(new HashSet());
        }
        for (int[] e : edges) {
            nodeList.get(e[0]).add(e[1]);
            nodeList.get(e[1]).add(e[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        seen.add(0);
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int next: nodeList.get(cur)) {
                if (seen.contains(next)) {
                    return false;
                }
                q.offer(next);
                seen.add(next);
                nodeList.get(next).remove(cur);
            }
            
        }
        return seen.size() == n;

    }
}

//dfs
class Solution {
    Set<Integer> seen = new HashSet<>();
    List<Set<Integer>> nodeList = new ArrayList<>();
    int n;
    public boolean validTree(int n, int[][] edges) {
        this.n = n;
        if (edges.length >= n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            nodeList.add(new HashSet());
        }
        for (int[] e : edges) {
            nodeList.get(e[0]).add(e[1]);
            nodeList.get(e[1]).add(e[0]);
        }
        seen.add(0);
        return dfs(0);
    }
    private boolean dfs(int cur) {
        Set<Integer> nextTmp = new HashSet<>(nodeList.get(cur));
        for (int next : nextTmp) {
            if (seen.contains(next)) {
                return false;
            }
            nodeList.get(next).remove(cur);
            seen.add(next);
            dfs(next);
        }
        return seen.size() == n;
    }
}

//union find
class Solution {
    public boolean validTree(int n, int[][] edges) {
        // if (edges.length >= n) {
        //     return false;
        // }
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            if (!uf.union(e[0], e[1])) {
                return false;
            }
       } 
       return uf.component == 1; //!!!!
    }
    public class UnionFind {
        int component;

        private int[] father;
        UnionFind(int n) {
            this.component = n;

            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }
        public int find(int i) {
            if (father[i] == i) {
                return i;
            }
            father[i] =  find(father[i]);
            return father[i];
        }

        public boolean union (int i, int j) {
            int fatherI = find(i);
            int fatherJ = find(j);
            if (fatherI != fatherJ) {
                father[fatherI] = fatherJ;
                component--;
                return true;
            }
            return false; // is already connected;
        }

        
    }
}
