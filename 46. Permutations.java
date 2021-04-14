class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
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
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            curRes.add(nums[i]);
            used[i] = true;
            helper(nums, curRes, used);
            curRes.remove(curRes.size() - 1);
            used[i] = false;
        }
    }
}