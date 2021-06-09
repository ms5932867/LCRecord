// compare  5,  516 and 1312
/**
 * If we know the longest palindromic sub-sequence is x and the length of the string is n then,
 *  what is the answer to this problem? 
 * It is n - x as we need n - x insertions to make the remaining characters also palindrome.
 *
 */

class Solution {
    public int minInsertions(String s) {
        if (s == null ) {
            return 0;
        }
        int l = s.length();
        if (l <= 1) {
            return 0;
        }
        /**
         * dp[i][j] is the length of the longest palindrome of s.substring(i, j + 1) which allows deletion, but no change in char order
         * base case if i == j dp[i][j] = 1
         * if i < j and char i == char j -> dp[i][j] = 2 + dp[i + 1][j - 1]
         * if i < j and char i != char j -> dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
         */ 
        int[][] dp = new int[l][l];
        int max = 1;
        for (int i = l - 1; i >= 0; i--) {
            for (int j = i; j < l; j++) {
                if (i == j){
                    dp[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return l - max;
    }
}