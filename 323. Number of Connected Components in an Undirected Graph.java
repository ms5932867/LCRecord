class Solution {    
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            uf.union(e[0], e[1]);
        }
        return uf.components; 
    }

    public class UnionFind {
        int components;
        int[] father;
        UnionFind(int components) {
            this.components = components;
            father = new int[components];
            for (int i = 0; i < components; i++) {
                father[i] = i;
            }
        }
        public void union(int i, int j) {
            int fatherI = find(i);
            int fatherJ = find(j);
            if (fatherI == fatherJ) {
                return;
            }
            father[fatherI] = fatherJ; // NOTE!!!!
            components--;
        }
        public int find(int i) {
            if (father[i] == i) {
                return i;
            }
            father[i] = find(father[i]);// NOTE!!!!
            return father[i];
        }
    }
    
}