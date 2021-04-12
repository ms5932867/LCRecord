//https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/

class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int s = 0;
        int e = nums.length - 1;
        while (s + 1 <  e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target || nums[s] == target || nums[e] == target) {
                return true;
            }
            if (nums[s] < target && target < nums[m]) { //左侧有序区间，启动二分查找
                e = m;
            } else if (nums[m] < target && target < nums[e]) { //右侧有序区间，启动二分查找
                s = m;
            } else { //仍在中间无序部分，左边界加1，右边界减一
                s++;
                e--;
            }
        }
        return nums[s] == target || nums[e] == target;
    }
}