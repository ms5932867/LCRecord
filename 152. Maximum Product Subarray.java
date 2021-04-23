// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.\
// maxSoFar  minSoFar 的意义是 包括当前的数字在内的目前为止最大or最小， 所以不会出现跳跃的情况
// 注意temp必须存在， 不然改动后的minSoFar 被计算到maxSoFar里面了!!!!!
// testcase: [2,3,-2,4,8,10, 4]
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int globalMax = maxSoFar;
        for (int i = 1; i < nums.length; i++) {
            int tmp = minSoFar;
            minSoFar = Math.min(nums[i], Math.min(nums[i] * maxSoFar, nums[i] * minSoFar));
            maxSoFar = Math.max(nums[i], Math.max(nums[i] * maxSoFar, nums[i] * tmp));
            globalMax =  Math.max(globalMax, maxSoFar);

            // System.out.println("i=" + i + " nums[i]="+ nums[i] + " minSoFar=" + minSoFar + " maxSoFar=" + maxSoFar + " globalMax=" + globalMax);
        }
        return globalMax;
    }
}