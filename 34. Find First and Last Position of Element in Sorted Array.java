class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        res[0] = helper(nums, target, true);
        res[1] = helper(nums,target, false);
        return res;
    }
    public int helper(int[] nums, int target, boolean findFirst) {
        int s = 0;
        int e = nums.length - 1;
        while (s + 1 < e) {
            int m = s +(e - s) / 2;
            if ((nums[m] == target && findFirst) || nums[m] > target ) {
                e = m;
            } else {
                s = m;
            }
            
        } 
        if (findFirst) {
            if (nums[s] == target ) {
                return s;
            } else if (nums[e] == target) {
                return e;
            }
        }
        if (nums[e] == target) {
            return e;
        } else if (nums[s] == target ) {
            return s;
        } 
        
        return -1;
    }
}