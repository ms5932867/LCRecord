//如果前边累加后还不如自己本身大，那就把前边的都扔掉，从此自己本身重新开始累加。
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int includeCur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            includeCur =  Math.max(nums[i], nums[i] + includeCur);
            max = Math.max(includeCur, max);
        }
        return max;
    }
}



class Solution {
    // -5, -4. -1, 7, -6, 8
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minPreSum = 0;
        int curPreSum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            curPreSum += nums[i];
            res = Math.max(res, curPreSum - minPreSum);
            
            minPreSum = Math.min(minPreSum, curPreSum);

            // System.out.println(minPreSum + " " + curPreSum + " " + res);
        }
        return res;
    }
}