// 1046. Last Stone Weight
// https://leetcode.com/problems/last-stone-weight/
/**
 * You are given an array of integers stones where stones[i] represents the weight of the ith stone.

We want to run a simulation on the stones as follows:

At each step we choose the two heaviest stones, with weight x and y and smash them togethers
If x == y, both stones are destroyed
If x < y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
Continue the simulation until there is no more than one stone remaining.

Return the weight of the last remaining stone or return 0 if none remain.

Example 1:

Input: stones = [2,3,6,2,4]

Output: 1
Explanation:
We smash 6 and 4 and are left with a 2, so the array becomes [2,3,2,2].
We smash 3 and 2 and are left with a 1, so the array becomes [1,2,2].
We smash 2 and 2, so the array becomes [1].
 */
//Method 1: Priority Queue time O(nlogn) space O(n) 
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int s: stones) {
            pq.offer(s);
        }
        while (pq.size() > 1) {
            int n1 = pq.poll();
            int n2 = pq.poll();
            if (n1 != n2) {
                pq.offer(Math.abs(n1 - n2));
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
// Method 2: Bucket Sort time O(n) space O(n)
       