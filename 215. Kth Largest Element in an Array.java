//quick sort and quick select
// 1. i <= j
// 2. i is the deviding point after one round
// 3. next round is i -1 and i + 1
class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums, k, 0, nums.length - 1);
        return nums[nums.length - k];
    }
    private void quickSelect(int[] nums, int k, int start, int end) {
        if (start > end)  {
            return;
        }
        int pivot = end;
        int i = start;
        int j = end - 1;
        while (i <= j) {
            if (nums[i] < nums[pivot]) {
                i++;
            } else {
                swap(nums, i, j);
                j--;
            }
        }
        swap(nums, i, pivot);
        if (i == nums.length - k) {
            return;
        } else if (i > nums.length - k) {
            quickSelect(nums, k, start, i - 1);
        } else {
            quickSelect(nums, k, i + 1, end);
        }

    }
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}