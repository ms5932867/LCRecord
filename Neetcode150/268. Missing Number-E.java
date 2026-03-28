/**
 * https://leetcode.com/problems/missing-number/
 * Missing Number
 * 

Given an array nums containing n integers in the range [0, n] without any duplicates, return the single number in the range that is missing from nums.

Follow-up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

Example 1:

Input: nums = [1,2,3]

Output: 0
Explanation: Since there are 3 numbers, the range is [0,3]. The missing number is 0 since it does not appear in nums.

Example 2:

Input: nums = [0,2]

Output: 1
 */
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int targetSum = (n + 1) * n / 2;
        for (int num : nums) {
            sum += num;
        }
        return targetSum - sum;
    }
}
/**
 * Find All Numbers Disappeared in An Array
 * You are given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Note: You can return the integers in any order.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]

Output: [5,6]
Example 2:

Input: nums = [1,1]

Output: [2]
 */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] *= (-1);
            } 
            
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            } 
        }
        return res;
    }
}
//leetcode 268. Missing Number
//leetcode 448. Find All Numbers Disappeared in an Array
/*
值的数量能不能一一映射到下标

✅ 能用 -1（Find Disappeared）
值：[1, n]（n个数）
下标：[0, n-1]（n个位置）

👉 一一对应 ✔️

❌ 不能用 -1（Missing Number）
值：[0, n]（n+1个数）
下标：[0, n-1]（n个位置）

👉 多一个 n + 有 0 ❌
*/