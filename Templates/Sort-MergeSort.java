class Solution {
    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length - 1);
        return nums;
    }
    private void divide(int[] nums, int s, int e) {
        if (s >= e) {
            return;
        }
        int m = s + (e - s) / 2;
        divide(nums, s, m);
        divide(nums, m + 1, e);
        merge(nums, s, m, e);
    }
    private void merge(int[] nums, int s, int m, int e) {
        int[] B = new int[e - s + 1];
        int index = 0;
        int i  = s;
        int j = m + 1;
        while (i <= m && j <= e) {
            if (nums[i] <= nums[j]) {
                B[index] = nums[i];
                i++;
            }
            else {
                B[index] = nums[j];
                j++;
            }
            index++;
        }
        if (i <= m) {
            System.arraycopy(nums, i, B, index, m - i + 1);
        }
        if (j <= e) {
            System.arraycopy(nums,j, B, index, e - j + 1);
        }
        System.arraycopy(B, 0, nums, s, e - s + 1);
    }
}