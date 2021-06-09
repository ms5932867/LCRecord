// compare  5,  516 and 1312
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int l = s.length();
        boolean[][] dp = new boolean[l][l]; // dp[i][j], substring(i, j+ 1), is palindrome or not
        int max = 1;
        String res = s.charAt(0) + "";

        for (int i = l - 1; i >= 0 ; i--) { 
            for (int j =  i; j < l; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else if (j - 1 < i + 1) {
                    dp[i][j] =  true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];// 决定了i从最大值开始, j从可能的最小值开始
                }
                if (dp[i][j] && j - i + 1 > max ) {
                    max = j - i + 1;
                    res = s.substring(i, j + 1);
                }      
                
            }
        }
        return res;
    }
}