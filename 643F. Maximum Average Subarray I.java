class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int curSum = 0;
        for (int i = 0; i < k; i++) {
            curSum += nums[i];
        }
        int maxSum = curSum;
        for (int j = k ; j < nums.length; j++) {
            
            curSum += nums[j];
            curSum -= nums[j - k];
            maxSum = Math.max(maxSum, curSum);
        }
        return (double)maxSum / k;
    }
}