/**
 * word1:  rw1 | c1
 * word2:  rw2 | c2
 * minDistance(w1, w2) -> 
 * case 0 : if  c1 == c2 -> minDistance(w1, w2) = minDistance(rw1, rw2)
 * if  c1 != c2 -> case1: insert c2 at end of w1-> minDistance(w1, w2) = 1 + minDistance(w1, rw2)
 *              -> case2: delete c1 at end of w1-> minDistance(w1, w2) = 1 + minDistance(rw1, w2)
 *              -> case3: replace c1 and c2 -> minDistance(w1, w2) = 1 + minDistance(rw1, rw2)  
 * dp[i][j] means the min distance of convert first i letter(index: 0-> i - 1) of w1 to first j letter (index: 0 -> j - 1)of w2
 * 为了能表示空字符串， 所以 4 x 4 的单词  ， matrix 是5 x 5
 * base case: dp[0][0] = 0; dp[0][j] = j; dp[i][0] = i; 
 * induction rule: dp[i][j] = 
 * case 0: if w1 charAt (i - 1) == w2 charAt(j - 1) if current two char are the same, nothing to do in this step-> dp[i][j] = dp[i-1][j-1]
 * if w1 charAt (i - 1) != w2 charAt(j - 1) -> case 1: dp[i][j] = 1 + dp[i][j -1]
 *                                          -> case 2: dp[i][j] = 1 + dp[i - 1][j]
 *                                          -> case 3: dp[i][j] = 1 + dp[i - 1][j - 1]
 * dp[i][j] = min(case1, 2, 3) if case0 does not meet
 */
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];

                } else {
                    dp[i][j] = Math.min(Math.min(1 + dp[i][j -1], 1 + dp[i - 1][j]), 1 + dp[i - 1][j - 1]);
                }
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[0].length; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println("");
        // }
        return dp[word1.length()][word2.length()];
        
    }
}
