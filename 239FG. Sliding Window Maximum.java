//https://zxi.mytechroad.com/blog/heap/leetcode-239-sliding-window-maximum/
// deque里存的是有可能成为答案的index。每次进来一个数， 把之前小于它的全部删掉。
// 所以deque里的数是从大到小的index
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        int[] res = new int[nums.length - k + 1];
         Deque<Integer> dq = new LinkedList<>();
        // save the index, that nums[index] could be a potential result. 
        // So eachtime, when add a new index j, remove all index i that   nums[i] <= nums[j]
        for (int i = 0; i < nums.length; i++) {
            
            while(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
            

            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }
            
            
        }
        return res;
    }
}