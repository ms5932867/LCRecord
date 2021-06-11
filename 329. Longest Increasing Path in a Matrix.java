class Solution {
    int[][] matrix;
    
    class Pair{
        int i;
        int j;
        Pair (int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public class PairComparator  implements Comparator<Pair> {
        public int compare (Pair p1, Pair p2){
            return matrix[p1.i][p1.j] - matrix[p2.i][p2.j];
        }
    }
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        List<Pair> pairs  = convertMatrixToPairs();
        int[][] sorted = getSortedIndex(pairs); // save the index of the Pair
        int[] dp = new int[pairs.size()];
        dp[0] = 1;
        int max = 1;
        int[] moveI = new int[]{1, -1, 0, 0};
        int[] moveJ = new int[]{0, 0, 1, -1};
        for (int p = 1; p < dp.length; p++) {
            int maxPrev= 0;
            Pair cur = pairs.get(p);
            for (int m = 0; m < moveI.length; m++) {
                Pair prePair = new Pair(cur.i + moveI[m], cur.j + moveJ[m]);
                if (validate(prePair, cur)) {
                    maxPrev = Math.max(maxPrev, dp[sorted[prePair.i][prePair.j]]);
                }
            }
            dp[p] = 1 + maxPrev;
            max = Math.max(max, dp[p]);
        }
        return max;
    }
    private boolean isNeighbor(Pair p1, Pair p2) {
        int[] moveI = new int[]{1, -1, 0, 0};
        int[] moveJ = new int[]{0, 0, 1, -1};
        for (int m = 0; m < moveI.length; m++) {
            if (p1.i == p2.i + moveI[m] && p1.j == p2.j + moveJ[m] ) {
                return true;
            }

        }
        return false;
    }
    private List<Pair> convertMatrixToPairs() {
        //convert Matrix To Pairs
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0 ; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pairs.add(new Pair(i, j));
            } 
        }
        Collections.sort(pairs, new PairComparator());
        
        return pairs;
    }
    private int[][] getSortedIndex(List<Pair> pairs) {
        int[][] sorted = new int[matrix.length][matrix[0].length];
        for (int n = 0 ; n < pairs.size(); n++) {
            sorted[pairs.get(n).i][pairs.get(n).j] = n;
        }
        return sorted;
    }
    private boolean validate(Pair pre, Pair cur) {
        if (pre.i < 0 || pre.i >= matrix.length || pre.j < 0 || pre.j >= matrix[0].length || matrix[pre.i][pre.j] >= matrix[cur.i][cur.j]) {
            return false;
        }
        return true;
    }
}