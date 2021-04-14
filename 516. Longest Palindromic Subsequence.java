// https://www.youtube.com/watch?v=v8irqkTcJ6s
class Solution {
    // b b b a b
    // 0 1 2 3 4
    //dp[i][j] the longest palindrom length of subtring from i to j (inclusive)
    //base case dp[i][i] = 1; dp[i][i-1] = 0;
    // dp[i][j] = 
     // 1. if char i == chat j -> dp[i][j] = 2 + dp[i + 1][j - 1]
     // 2. if char i != chat j -> dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
    // todo 1d array
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int l = s.length();
        int[][] dp = new int[l][l];
        
        for (int i = l - 1; i >= 0 ; i--) {
            for (int j = i; j < l; j++) { //注意 i j 起始的位置， 为什么要从这个位置开始？ 终点是【0】【l-1]， 从终点的反方向开始
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
                
            }

        }
        // for (int i = 0; i < l; i++) {
        //     for (int j = 0; j < l; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println("");
        // }
        return dp[0][l - 1];
    }
}