/**
 * https://www.cnblogs.com/grandyang/p/11716314.html
 * 这道题让求环形子数组的最大和，对于环形数组，我们应该并不陌生，之前也做过类似的题目 
 * [Circular Array Loop](http://www.cnblogs.com/grandyang/p/7658128.html)，
 * 就是说遍历到末尾之后又能回到开头继续遍历。假如没有环形数组这一个条件，
 * 其实就跟之前那道 [Maximum Subarray](http://www.cnblogs.com/grandyang/p/4377150.html) 一样，
 * 解法比较直接易懂。这里加上了环形数组的条件，难度就增加了一些，需要用到一些 trick。
 * 既然是子数组，则意味着必须是相连的数字，而由于环形数组的存在，说明可以首尾相连，这样的话，
 * 最长子数组的范围可以有两种情况，
 * 一种是正常的，数组中的某一段子数组，另一种是分为两段的，即首尾相连的，
 * 可以参见 [大神 lee215 的帖子]
 * (https://leetcode.com/problems/maximum-sum-circular-subarray/discuss/178422/One-Pass)
 *  中的示意图。
 * 对于第一种情况，其实就是之前那道题 [Maximum Subarray](http://www.cnblogs.com/grandyang/p/4377150.html) 的做法，
 * 对于第二种情况，需要转换一下思路，除去两段的部分，中间剩的那段子数组其实是和最小的子数组，
 * 只要用之前的方法求出子数组的最小和，用数组总数字和一减，
 * 同样可以得到最大和。
 * 两种情况的最大和都要计算出来，取二者之间的较大值才是真正的和最大的子数组。
 * 但是这里有个 corner case 需要注意一下，假如数组中全是负数，那么和最小的子数组就是原数组本身，
 * 则求出的差值是0，而第一种情况求出的和最大的子数组也应该是负数，那么二者一比较，返回0就不对了，
 * 所以这种特殊情况需要单独处理一下，
 */
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = nums[0]; // sum for all num
        int maxSum = nums[0]; // max sum of any subarray
        int curMax = nums[0]; // include the cur num, the max sum of the subarray

        int minSum = nums[0]; // min sum of any subarray
        int curMin = nums[0]; // include the cur num, the min sum of the subarray 

        for (int index = 1; index < nums.length; index++) {
            int i = nums[index];
            sum += i;

            curMax = Math.max(i, curMax + i);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(i, curMin + i);
            minSum = Math.min(minSum, curMin);
        }
        if (sum == minSum) {
            return maxSum;
        }
        return Math.max(maxSum, sum - minSum);
    }
}