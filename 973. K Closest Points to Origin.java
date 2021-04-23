import java.util.PriorityQueue;
class Solution {
    private int helper(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> helper(y) - helper(x));
        for (int[] p: points) {
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] res = new int[k][2];
        
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}