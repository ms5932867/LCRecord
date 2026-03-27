/**
 * 704. Binary Search  
 * You are given an array of distinct integers nums, sorted in ascending order, and an integer target.

Implement a function to search for target within nums. If it exists, then return its index, otherwise, return -1.

Your solution must run in O(logn) time.

Example 1:

Input: nums = [-1,0,2,4,6,8], target = 4

Output: 3
Example 2:

Input: nums = [-1,0,2,4,6,8], target = 3

Output: -1
Constraints:

1 <= nums.length <= 10000.
-10000 < nums[i], target < 10000
All the integers in nums are unique. 
 */
// Iterative
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                return m;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
//  Recursive
class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }
    private int helper(int[] nums, int target, int l, int r) {
        if (r < l) {
            return -1;
        }
        int m = l + (r - l) / 2;

        if (target == nums[m]) {
            return m;
        } 
        return target > nums[m] ? 
        helper(nums, target,m + 1, r) : helper(nums, target, l, m - 1);
    }
}

