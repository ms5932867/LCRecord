// Solution 1: HashMap: Time: O(n) Space: O(n)
// Cannot use HashSet because the difference k may be 0!!!
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.putIfAbsent(n, 0);
            map.put(n, map.get(n) + 1);
        }
        int cnt = 0;
        for (int n: map.keySet()) {
            if (k != 0 && map.containsKey(n + k)) {
                cnt++;
            } else if (k == 0 && map.get(n) > 1) {
                cnt++;
            }
        } 
        return cnt;
    }
}

// Solution 2: two pointer: Time: O(nLogn) Space: O(1)
class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        if (k == 0) {
            return helperK0(nums);
        }
        return helper(nums, Math.abs(k));
    }
    private int helperK0(int[] nums) {
        int cnt = 0;
        int lastUsed = nums[0] - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i] && nums[i] != lastUsed) {
                cnt++;
                lastUsed = nums[i];
            }
        }
        return cnt;
    }
    private int helper(int[] nums, int k) {
        int l = 0;
        int lastUsed = nums[0] - 1;
        int cnt = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] - nums[l] == k && nums[l] != lastUsed) {
                cnt++;
                lastUsed = nums[l];
            } else if (nums[r] - nums[l] > k) {
                l++;
                r--; // This is really important!!! we want to keep the same r when changing l!!!
            }
        }
        return cnt;
    } 
}