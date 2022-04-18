/**
 * 	两个挡板 i和j  三个区域 i++ j-- i j 对着头走
	[0…i) i的左侧不含i 全部是比nums[pivot]小的数字 
	[i…j] 未知探索区
    (j….)  j的右侧不含j 全部是比nums[pivot]大于等于的数字
 */
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    private void quickSort(int[] nums, int s, int e) {
        // remember when to end the recursion!!!
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
        /**
         *  0…i) i的左侧不含i 全部是比pivot小的数字 
	        [i…j] 未知探索区
            (j….)  j的右侧不含j 全部是比pivot大于等于的数字
                why swap i here?  ..... j , i .......pivot 
            -> 因为大于等于nums[pivot]的数字 一定存在 所以 index i 一定valid
              小于nums[pivot]的数字不一定存在， 所以index j 有可能 不valid
         */
        
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