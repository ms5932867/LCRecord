class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1 ; j <= Math.min(i + nums[i], nums.length - 1); j++) {
                if (!dp[j]) {
                    dp[j] = dp[i];
                }
                
            }
        }
        return dp[dp.length - 1];
    }
}