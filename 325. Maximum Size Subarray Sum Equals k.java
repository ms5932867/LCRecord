import java.util.Map;
// Input: nums = [1,-1,5,-2,3], k = 3
// Output: 4
// Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.


class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int preSum = 0;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) {
                max = Math.max(max, i - map.get(preSum - k));
            }
            map.putIfAbsent(preSum, i);
        }
        return max;
    }
}