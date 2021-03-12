// You are given coins of different denominations and a total amount of money.
// Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
// Example 1:

// Input: amount = 5, coins = [1, 2, 5]
// Output: 4
// Explanation: there are four ways to make up the amount:
// 5=5
// 5=2+2+1
// 5=2+1+1+1
// 5=1+1+1+1+1
// Example 2:

// Input: amount = 3, coins = [2]
// Output: 0
// Explanation: the amount of 3 cannot be made up just with coins of 2.
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c :coins) {
            for (int i = c; i < dp.length; i++) {
                
                    dp[i] += dp[i - c];
                
            }
        }
        return dp[amount];
    }
}
//The fun part about this solution is that if you switch the order of the for loops in the code, your answer almost doubles! 
//Learnt it the hard way.

// If you're wondering why, here's a hint:

// To make an amount of 3 with two coin denominations 1 and 2, you can go:
// 1 + 2 = 3
// 2 + 1 = 3
// Both mean the same thing, in this question.