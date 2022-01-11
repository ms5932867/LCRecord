class Solution {
    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        } 
        int l = 0; 
        int maxCnt = 0;
        int used = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                used++;
            }   
            while (used > k) {
                if (nums[l] == 0) {
                    used--;  
                }
                l++;
            }
            maxCnt = Math.max(maxCnt, r - l + 1);  
            // System.out.println("l=" + l + " r=" + r + " maxCnt=" + maxCnt + " used=" + used);
        }
        return maxCnt;
    }
}