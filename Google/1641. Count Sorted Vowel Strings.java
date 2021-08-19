//dfs
// class Solution {
//     int cnt = 0;
//     public int countVowelStrings(int n) {
//         char[] vowels = new char[]{'a','e','i','o','u'};
//         dfs(vowels, new StringBuilder(), n, 0);
//         return cnt;
//     }
//     private void dfs(char[] vowels, StringBuilder cur, int n, int startIndex) {
//         if (cur.length() == n) {
//             cnt++;
//             return;
//         }
//         for (int i = startIndex; i < vowels.length; i++) {
//             cur.append(vowels[i]);
//             dfs(vowels, cur, n, i);
//             cur.deleteCharAt(cur.length() - 1);
//         }
//     }
// }

class Solution {
    public int countVowelStrings(int n) {
        if (n == 0) {
            return 0;
        }
        int vowel = 5;
        int[][] dp = new int[vowel + 1][n + 1];
        // dp[i][j] means the count of strings of i vowels with length j
        //dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        for (int i = 1; i <= vowel; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1) {
                    dp[i][j] = 1;
                    continue;
                }
                if (j == 1) {
                    dp[i][j] = i;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // for (int i = 0; i <= vowel; i++) {
        //     for (int j = 0; j <= n; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println(" ");
        // }
        return dp[vowel][n];
    }
}
