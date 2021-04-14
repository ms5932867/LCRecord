class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> curRes = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, curRes, used);
        return res;
    }
    private void helper(int[] nums, List<Integer> curRes, boolean[] used) {
        if (curRes.size() == nums.length) {
            res.add(new ArrayList<>(curRes));
            return;
        }
        // i = 0 && !used[0]
        // nums[i] != nums[i - 1] && !used[i]
        // nums[i] == nums[i - 1] && !used[i] && used[i - 1]
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                //要解决重复问题，我们只要设定一个规则，保证在填第 \textit{idx}idx 个数的时候重复数字只会被填入一次即可。
                //而在本题解中，我们选择对原数组排序，保证相同的数字都相邻，然后每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」
                // 链接：https://leetcode-cn.com/problems/permutations-ii/solution/quan-pai-lie-ii-by-leetcode-solution/

                continue;
            }
            // if ((i == 0 ) || (i > 0 && nums[i] != nums[i - 1] ) || (i > 0 && nums[i] == nums[i - 1] && used[i - 1])) {
                used[i] = true;
                curRes.add(nums[i]);
                helper(nums, curRes, used);
                used[i] = false;
                curRes.remove(curRes.size() - 1);
            // }
        }
    }
}