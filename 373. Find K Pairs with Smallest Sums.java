import java.util.PriorityQueue;

// class Solution {
//     public class Pair{
//         int m;
//         int n;
//         Pair (int m, int n) {
//             this.m = m;
//             this. n = n;
//         }
//     }
//     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//         PriorityQueue<Pair> pq = new PriorityQueue<>(k, (p1, p2) -> Integer.compare(p2.m + p2.n, p1.m + p1.n)); 
//         //max heap, pop the pair with largest sum
//         for (int i = 0; i < nums1.length; i++) {
//             for (int j = 0; j < nums2.length; j++) {
//                 pq.offer(new Pair(nums1[i], nums2[j]));
//                 if (pq.size() > k) {
//                     pq.poll();
//                 }
//             }
//         }
//         List<List<Integer>> res = new ArrayList<>();
//         while(!pq.isEmpty()) {
//             Pair cur = pq.poll();
//             res.add(new ArrayList<>(Arrays.asList(cur.m, cur.n)));
//         }
//         return res;
//     }
// }


class Solution {
    public class Pair{
        int m;// index
        int n;// index
        int sum;
        Pair (int m, int n, int sum) {
            this.m = m;
            this.n = n;
            this.sum = sum;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, (p1, p2) -> Integer.compare(p1.sum, p2.sum)); // min heap
        for (int j = 0; j < nums2.length; j++) {
            pq.offer(new Pair(0, j,  nums1[0] + nums2[j]));
        }
        List<List<Integer>> res = new ArrayList<>();
        while (res.size() < Math.min(k, nums1.length * nums2.length)) {
            Pair cur = pq.poll();
            res.add(new ArrayList<>(Arrays.asList(nums1[cur.m], nums2[cur.n])));
            if (cur.m + 1 < nums1.length) {
                pq.offer(new Pair(cur.m + 1, cur.n, nums1[cur.m + 1] + nums2[cur.n]));
            }
        }
        return res;
    
    }
}