// class Solution {
//     public int integerBreak(int n) {
//         int[] dp = new int[n + 1];
//         dp[0] = 0;
//         dp[1] = 0;
//         // dp[i] =
//         // j : 1 .... i / 2
//         // dp[i] = Max(max(j, dp[j]), max(i - j, dp[i - j]))
//         for (int i = 2 ; i <= n; i++) {
//             int curMax = 0;
//             for (int j = 1; j <= i / 2; j++) {
//                 curMax = Math.max(curMax, Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
//             }
//             dp[i] = curMax;
//         }
//         return dp[n];
//     }
// }


class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        // dp[i] =
        // j : 1 .... i / 2
        // dp[i] = j, max(i - j, dp[i - j]))
        for (int i = 2 ; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, j * Math.max(i - j, dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}