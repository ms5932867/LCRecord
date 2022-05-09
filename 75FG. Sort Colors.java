/**
 * 1. https://www.cnblogs.com/grandyang/p/4341243.html
 * 题目中还要让只遍历一次数组来求解，那么就需要用双指针来做，分别从原数组的首尾往中心移动。

- 定义 red 指针指向开头位置，blue 指针指向末尾位置。

- 从头开始遍历原数组，
如果遇到0，则交换该值和 red 指针指向的值，并将 red 指针后移一位。
若遇到2，则交换该值和 blue 指针指向的值，并将 blue 指针前移一位。若遇到1，则继续遍历。
*/
class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        for (int index = 0; index <= two; index++) {
            if (nums[index] == 0) {
                swap(nums, index, zero);
                zero++;
                
            } else if (nums[index] == 2) {
                swap(nums, index, two);
                two--;
                index--;
            } 
        }
        
    }
    private void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }
}


/** 
2. https://users.monash.edu/~lloyd/tildeAlgDS/Sort/Flag/
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