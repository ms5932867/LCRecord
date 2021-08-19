//https://www.cnblogs.com/cnoodle/p/14877074.html

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int res = Integer.MIN_VALUE;
        while (i < j) {
            res = Math.max(res, nums[i] + nums[j]);
            i++;
            j--;
        }
        return res;
    }
}