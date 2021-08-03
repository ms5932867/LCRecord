class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int cnt = 0;
        int left = 0;
        int right = 0;
        int curRes = 1;
        while (left < nums.length && right < nums.length) {
            curRes *= nums[right];
            while (curRes >= k) {
                curRes /= nums[left];
                left++;   
            } 
            cnt += (right - left + 1);
            right++;
        }
        return cnt;
        
    }
}