/**
 * 53. Maximum Subarray
Given an integer array nums, find the subarray with the largest sum, and return its sum.
Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */

/**
 * 它们为什么等价

因为“以 i 结尾的最大子数组”这件事，本来就可以有两种表达：

Kadane 表达
要么只取自己
要么接上前面的 ending max
前缀和表达
固定右端点 i
找左边最小前缀和来做差

这两个是在算同一个东西。

四、两种方法怎么理解更顺
方法 1（Kadane）更像 DP

你会想：

“当前位置要不要跟前面连起来？”

很适合面试里快速写。

核心一句：

curMax = Math.max(nums[i], curMax + nums[i]);
方法 2（prefix sum）更像数学

你会想：

“固定右端点，左边找一个最小前缀和，让差最大。”

它的优点是：

思路很统一
容易推广到一些前缀和相关题
对“subarray sum = prefix difference”这个模型理解很有帮助
 */
/**
 * Solution 1: Kadane's Algorithm
 维护 curMax = 以当前位置结尾的最大子数组和

 */
class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            res = Math.max(res, curMax);
        }
        return res;
    }
}

/**
 * Solution 2: Prefix Sum
 * 维护当前前缀和 sum
维护历史最小前缀和 minSum
当前答案候选：
sum - minSum
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int minSum = 0;
        int res = Integer.MIN_VALUE;

        for (int n : nums) {
            sum += n;
            res = Math.max(res, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return res;
    }
}