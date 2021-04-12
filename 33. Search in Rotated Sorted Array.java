//https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/
// see leetcode 81
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int s = 0;
        int e = nums.length - 1;
        while (s + 1 <  e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[s] == target) {
                return s;
            }
            if (nums[e] == target) {
                return e;
            }

            if (target > nums[s] && target < nums[m]) {
                e = m;
            } else if (target > nums[m] && target < nums[e]) {
                s = m;
            } else {
                s++;
                e--;
            }
        }
        if (nums[s] == target) {
            return s;
        } 
        if (nums[e] == target) {
            return e;
        } 
        return -1;
    }
}