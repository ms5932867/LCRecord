import java.util.PriorityQueue;
class Solution {
    // if k is even, answer is the mean of minPQ.poll() and maxPQ.poll()
    // if k is odd, answer is maxPQ.pop(). keep the size of maxPQ  - the size of minPQ = 1
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        // pop the min everytime,  to store the larger half of the numbers. size = k / 2;
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(k, Collections.reverseOrder()); 
        // pop the max everytime,to store the smaller half of the numbers, size = k - k / 2;
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < k - 1; i++) {
            minPQ.offer(nums[i]);
        }
        for (int i = k - 1; i < nums.length; i++) {
            if (i >= k) {
                // need to remove nums[i - k] and add nums[i]
                if (!minPQ.remove(nums[i - k])) {
                    maxPQ.remove(nums[i - k]);
                }
            } 

            minPQ.offer(nums[i]);
            // at this moment maxPQ contains the right number at the right order,
            // but minPQ may be disordered and contains the number it should not contain
            while(minPQ.size() > 0 && maxPQ.size() > 0 && maxPQ.peek() > minPQ.peek()) { 
                minPQ.offer(maxPQ.poll()); 
            }
            while (maxPQ.size() < k -  k / 2 ) {
                maxPQ.offer(minPQ.poll());
            }

            res[i - (k - 1)] = k % 2 == 1 ? maxPQ.peek() : ((double)minPQ.peek() + (double)maxPQ.peek()) / 2;
        }
        return res;
    }
}