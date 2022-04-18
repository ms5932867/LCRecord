// https://leetcode.com/problems/sort-an-array/discuss/492042/7-sorting-algorithms-quick-sort-top-downbottom-up-merge-sort-heap-sort-etc/1335468
class Solution {
    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length - 1);
        return nums;
    }
    private void divide(int[] nums, int s, int e) {
        if (s >= e) { // note > and =, otherwise stack overflow, if s == m == e
            return;
        }
        int m = s + (e - s) / 2;
        // System.out.println("s=" + s + " m=" + m + " e=" + e);
        
        divide(nums, s, m);
        divide(nums, m + 1, e);
        merge(nums, s, m, e);
    }
    private void merge(int[] nums, int s, int m, int e) {
        int[] tmp = new int[e - s + 1];
        int i  = s;
        int j = m + 1;
        for (int index = 0; index < tmp.length; index++) {
            if (j > e ||  i <= m && nums[i] <= nums[j]) {
                tmp[index] = nums[i];
                i++;
            }
            else {
                tmp[index] = nums[j];
                j++;
            }

        }
        System.arraycopy(tmp, 0, nums, s, e - s + 1);
    }
}