/**
https://users.monash.edu/~lloyd/tildeAlgDS/Sort/Flag/
this is also known as three-way quicksort partitioning. The invariants are:

(1) [0,lo) have elements less than the pivot (in our case, think of pivot as 1).
(2) [lo, hi] have elements equal to the pivot
(3) (hi,end] have elements greater than the pivot

*/
class Solution {
    public void sortColors(int[] nums) {
       int lo = 0, hi = nums.length - 1, i = 0;

        while (i <= hi) {
            if (nums[i] == 0) {
               swap(nums, lo, i);
                lo++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, hi);
                hi--;
            } else if (nums[i] == 1) {
                i++;
            }
            
        }
        
    }
    private void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }
    
}