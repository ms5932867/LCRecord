class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        //List<Integer> 0: frequency, first index, last index
        int maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{1, i, 0});
            }
            else {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }
            
            maxFreq = Math.max(map.get(nums[i])[0], maxFreq);
        }
        if (maxFreq == 1) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for (int i : map.keySet()) {
            if (map.get(i)[0] == maxFreq) {
                min = Math.min(min,map.get(i)[2] - map.get(i)[1] + 1);
            }
        }
        return min;
    }
}