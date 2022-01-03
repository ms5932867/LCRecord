//只需要找到一个peak， 所以可以通过和neighbor比较来确定下一步往左还是往右。
class Solution {
    public int findPeakElement(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        while (s + 1 < e) {
            int m = s + (e - s) / 2;
            if (nums[m] < nums[m + 1]) {
                s = m;
            } else {
                e = m;
            }
        }
        if (nums[s] > nums[e]) {
            return s;
        }
        return e;
    }
}