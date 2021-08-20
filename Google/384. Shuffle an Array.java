class Solution {
    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = new int[nums.length];
        System.arraycopy(nums,0, res,0, nums.length);
        
        for (int i = 0; i < nums.length; i++) {
            int swapIndex = (int)(Math.random() * (nums.length - i))+ i;
            int temp = res[i];
            res[i] = res[swapIndex];
            res[swapIndex] = temp;


        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */