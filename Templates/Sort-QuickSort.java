class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    private void quickSort(int[] nums, int s, int e) {
        if (s >= e) {
            return;
        }
        int i = s;
        int j = e - 1;
        int pivot = e; // pivot is last index
        while (i <= j) {
            if (nums[i] < nums[pivot]) {
                i++;
            } else {
                swap(nums, i, j);
                j--;
            }
        }
        swap(nums, i, pivot);
        quickSort(nums, s, i - 1);
        quickSort(nums, i + 1, e);
    }
    private void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }
}