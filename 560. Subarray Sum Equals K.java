class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // sum and cnt 
        map.put(0, 1);
        int preSum = 0;
        int cnt = 0;
        for (int n : nums) {
            preSum += n;
            if (map.containsKey(preSum - k)) {
                cnt += map.get(preSum - k);
            }
            map.putIfAbsent(preSum, 0);
            map.put(preSum, map.get(preSum) + 1);
        }
        return cnt;
    }
}