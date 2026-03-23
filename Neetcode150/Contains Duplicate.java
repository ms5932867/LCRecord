/*
HashSet
Time complexity:  O(n) Space complexity: O(n)
*/
class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) {
            if (seen.contains(n)) {
                return true;
            } 
            seen.add(n);
        }
        return false;
    }
}

/*
Sort
Time complexity: O(nlogn) 
Space complexity:  O(1) or O(n) depending on the sorting algorithm.
*/
class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}