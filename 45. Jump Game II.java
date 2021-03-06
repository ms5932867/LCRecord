class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            for (int j = 1; j <= nums[i] && i + j < dp.length; j++) {
                dp[i + j] = Math.min(dp[i] + 1,dp[i + j]);
            }
        }
        return dp[nums.length - 1];
    }
}

class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;
        // dp[i] means min step to reach i
        // dp[i] = 
        // or j from 0 to i - 1, if (nums[j] + j >= i) -> dp[i] = min (dp [j] + 1)
        for (int i = 1; i < dp.length; i++) {
            int curMin = dp.length;
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i ) {
                    curMin = Math.min(curMin, dp[j] + 1);
                }
            }
            dp[i] = curMin;
        }
        return dp[dp.length - 1];
    }
}