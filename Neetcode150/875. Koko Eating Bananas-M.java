// 875. Koko Eating Bananas
// https://leetcode.com/problems/koko-eating-bananas/
/** 
 * You are given an integer array piles where piles[i] is the number of bananas in the ith pile. You are also given an integer h, which represents the number of hours you have to eat all the bananas.

You may decide your bananas-per-hour eating rate of k. Each hour, you may choose a pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, you may finish eating the pile but you can not eat from another pile in the same hour.

Return the minimum integer k such that you can eat all the bananas within h hours.

Example 1:

Input: piles = [1,4,3,2], h = 9

Output: 2
Explanation: With an eating rate of 2, you can eat the bananas in 6 hours. With an eating rate of 1, you would need 10 hours to eat all the bananas (which exceeds h=9), thus the minimum eating rate is 2.
*/
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            int hour = getHours(piles, m);
            if (hour > h) {
                l = m;
            } else {
                r = m;
            }
        }
        if (getHours(piles, l) <= h) {
            return l;
        }
        return r;
        
    }
    private int getHours(int[] piles, int m) {
       int hour = 0;
       for (int p : piles) {
            hour += p / m;
            if (p % m != 0) {
                hour++; 
            } 
       } 
       return hour;
    }
}

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        // for (int p: piles) {
        //     r = Math.max(r, p);
        // }
        while (l <= r) {
            int m = l + (r - l) / 2;
            int hour = getHours(piles, m);
            if (hour > h) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
        
    }
    private int getHours(int[] piles, int m) {
       int hour = 0;
       for (int p : piles) {
            hour += p / m;
            if (p % m != 0) {
                hour++; 
            } 
       } 
       return hour;
    }
}

