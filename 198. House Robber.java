class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = new int[nums.length + 1];
        sum[0] = 0;
        sum[1] = nums[0];
        sum[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i < sum.length; i++) {
            sum[i] = Math.max(sum[i - 2] + nums[i -1], sum[i - 1]);
        }
        return sum[sum.length - 1];
    }
}