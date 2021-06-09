class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int tmp = 0;
        int max = 0;
        for (int i : nums) {
            if (i == 1) {
                tmp++;
                max = Math.max(max, tmp);
            } else {
                tmp = 0;
            }
        }
        return max;
    }
}