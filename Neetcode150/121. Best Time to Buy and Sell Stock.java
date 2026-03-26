
/**
 * 121. Best Time to Buy and Sell Stock
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * You may choose a single day to buy one stock and choose a different day in the future to sell it.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int p :prices) {
            maxProfit = Math.max(maxProfit, p - min);
            min = Math.min(min, p);
        }
        return maxProfit < 0 ? 0: maxProfit;
    }
}
/**
 * You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.

You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.

Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.

Example 1:

Input: prices = [10,1,5,6,7,1]

Output: 6
Explanation: Buy prices[1] and sell prices[4], profit = 7 - 1 = 6.

Example 2:

Input: prices = [10,8,7,5,2]

Output: 0
Explanation: No profitable transactions can be made, thus the max profit is 0.


 */