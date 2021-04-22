class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int last = findLastIndex(nums, i, j);
                // the index of the last num that is smaller than target
                cnt += (last - j );
            }
        }
        return cnt;
    }
    private int findLastIndex(int[] nums, int i, int j) {
        int target =  nums[i] + nums[j]; // find a number < target
        int s = j + 1;
        int e = nums.length - 1;
        while (s + 1 < e) {
            int m = s + (e - s) / 2;
            if (nums[m] >= target) {
                e = m - 1;
            } else {
                s = m;
            }
        }
        if (nums[e] < target) {
            return e;
        }
        if (nums[s] < target) {
            return s;
        }
        return j; 
        // it is possible that there's no answer!
    }
}