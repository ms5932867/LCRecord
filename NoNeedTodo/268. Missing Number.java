class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectSum = (1 + n) * n / 2;
        int sum = 0;
        for (int i: nums) {
            sum += i;
        }
        return expectSum - sum;
    }
}