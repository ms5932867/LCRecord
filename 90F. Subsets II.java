// 90. Subsets II
// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

 class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(0, nums, res, new ArrayList<>());
        return res;
    }
    private void helper(int start, int[] nums, List<List<Integer>> res, List<Integer> curRes) {
        res.add(new ArrayList<>(curRes));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) { 
                // 因为在同一层中：第一个相同的元素已经作为分支起点使用过了 后面的相同元素如果再作为起点，会生成重复结果
                continue;
            }
            curRes.add(nums[i]);
            helper(i + 1, nums, res, curRes);
            curRes.remove(curRes.size() - 1);
        }
    }
}
/*
Subsets II 去重核心解释】

条件：

if (i > start && nums[i] == nums[i - 1]) continue;

含义拆解：

i > start
表示当前元素不是这一层的第一个元素
=> 用来限定“只在同一层进行去重”
nums[i] == nums[i - 1]
表示当前元素和前一个元素相同
=> 说明这是重复数字（因为数组已排序）

【合在一起的意思】

如果当前元素和前一个元素相同，并且它不是这一层的第一个元素，那么跳过。

【为什么可以去重】

因为在同一层中：

第一个相同的元素已经作为分支起点使用过了
后面的相同元素如果再作为起点，会生成重复结果

例如 nums = [1,2,2]

在同一层：

i = 1 -> 选第一个 2 -> [2]
i = 2 -> 选第二个 2 -> [2] (重复)

所以第二个要跳过

【为什么一定要写 i > start】

因为我们只想“同一层去重”，不能影响下一层

例如：

路径：[] -> 选第一个2 -> [2]
下一层 start = 2
此时应该允许选第二个2，得到 [2,2]

如果写成 i > 0，就会错误地把这个合法情况跳过

【总结一句话】

i > start 保证只在同一层去重
nums[i] == nums[i - 1] 判断是否重复
=> 同一层中，相同元素只保留第一个分支
*/

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