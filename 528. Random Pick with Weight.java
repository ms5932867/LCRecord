// You are given an array of positive integers w where w[i] describes the weight of ith index (0-indexed).

// We need to call the function pickIndex() which randomly returns an integer in the range [0, w.length - 1]. pickIndex() should return the integer proportional to its weight in the w array. For example, for w = [1, 3], the probability of picking the index 0 is 1 / (1 + 3) = 0.25 (i.e 25%) while the probability of picking the index 1 is 3 / (1 + 3) = 0.75 (i.e 75%).

// More formally, the probability of picking index i is w[i] / sum(w).

 

// Example 1:

// Input
// ["Solution","pickIndex"]
// [[[1]],[]]
// Output
// [null,0]

// Explanation
// Solution solution = new Solution([1]);
// solution.pickIndex(); // return 0. Since there is only one single element on the array the only option is to return the first element.
// Example 2:

// Input
// ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
// [[[1,3]],[],[],[],[],[]]
// Output
// [null,1,1,1,1,0]

// Explanation
// Solution solution = new Solution([1, 3]);
// solution.pickIndex(); // return 1. It's returning the second element (index = 1) that has probability of 3/4.
// solution.pickIndex(); // return 1
// solution.pickIndex(); // return 1
// solution.pickIndex(); // return 1
// solution.pickIndex(); // return 0. It's returning the first element (index = 0) that has probability of 1/4.

// Since this is a randomization problem, multiple answers are allowed so the following outputs can be considered correct :
// [null,1,1,1,1,0]
// [null,1,1,1,1,1]
// [null,1,1,1,0,0]
// [null,1,1,1,0,1]
// [null,1,0,1,0,0]
// ......
// and so on.
 

// Constraints:

// 1 <= w.length <= 10000
// 1 <= w[i] <= 10^5
// pickIndex will be called at most 10000 times.

class Solution {
    int[] preSum;
    public Solution(int[] w) {
        preSum = new int[w.length];
        preSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            preSum[i] = preSum[i - 1] + w[i];
        }
    }
    
    public int pickIndex() {
        int sum = preSum[preSum.length - 1];
        int target = (int)(Math.random() * sum) + 1; //[1, 10] start from 1, right side also needs to be included
        int res = binarySearch(target, preSum);
        return res;
    }

    private int linearSearch(int target, int[] preSum) {
        for (int i = 0; i < preSum.length; i++) {
            if (target <= preSum[i]) {
                return i;
            }
        } 
        return -1;
    }
    private int binarySearch(int target, int[] preSum) {
        int s = 0;
        int e = preSum.length - 1;
        while (s + 1 <  e) {
            int m = s + (e - s) / 2;
            if (target == preSum[m]) {
                return m;
            } 
            else if (target > preSum[m]) {
                s = m;
            } 
            else {
                e = m;
            }
        }
        if (preSum[s] >= target) {
            return s;
        }
        return e;    
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */