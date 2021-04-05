class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int lastIndex = binarySearch(nums, nums[i] + nums[j], j + 1);
                // 注意！！！： j + 1有可能出边界
                if (lastIndex != -1) {
                    cnt += lastIndex - j;
                }
            }
        }
        return cnt;
    }
    private int binarySearch(int[] nums, int target, int s) { // s : start index
        // the index of the last num that is smaller than target
        int e = nums.length - 1;
        while (s + 1 <  e) {
            int m = s + (e - s) / 2;
            if (nums[m] >= target) {
                e = m - 1;
            }
            else {
                s = m;
            }
        }
        if (nums[e] < target) {
            return e;
        }
        if (nums[s] < target) {
            return s;
        }
        return -1;
    }
}