class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, 0, new ArrayList<>());
        return res;
    }
    private void dfs(int[] nums, boolean[] used, int index, List<Integer> curRes) {
        if (index == nums.length) {
            res.add(new ArrayList<>(curRes));
            return;
        }
        if (index == 0 || nums[index - 1] != nums[index] || used[index - 1] == true) {
            curRes.add(nums[index]);
            used[index] = true;
            dfs(nums, used, index + 1, curRes);
            curRes.remove(curRes.size() - 1);
            used[index] = false;
        }
        

        dfs(nums, used, index + 1, curRes);
      
        
    }
}