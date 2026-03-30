// 78. Subsets
// https://leetcode.com/problems/subsets/
/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 */
// time: O(n * 2^n) 
// space: O(n * 2^n) because we need to store the result, and each subset can have up to n elements, so the total space needed is O(n * 2^n) in the worst case.
/**
[]
[3]
[2]
[2,3]
[1]
[1,3]
[1,2]
[1,2,3]

👉 递归是“先走到最深，再回头”
所以谁最先“走到叶子”，谁就最先被加入结果。

🔍 看你的代码顺序
// 不选
helper(idx + 1, ...);
// 选
curRes.add(nums[idx]);
helper(idx + 1, ...);

👉 永远是：
先不选当前数
🌳 用 [1,2,3] 画真实执行路径

我们只看第一次走到底的路径：
从根开始
[]
idx = 0 (1)
1️⃣ 不选 1
[]
idx = 1 (2)
2️⃣ 不选 2
[]
idx = 2 (3)
3️⃣ 不选 3
[]
idx = 3（到底了）

👉 第一个结果：
[]
🔥 接下来发生什么（关键）
回到 idx = 2（处理数字 3）
刚刚走的是：
不选 3
现在走：
选 3
[3]
idx = 3
👉 第二个结果：
[3]
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, nums, res, new ArrayList<>());
        return res;
    }
    private void helper(int idx, int[] nums, List<List<Integer>> res, List<Integer> curRes) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(curRes));
            return;
        }
        // 不加这个数
        helper(idx + 1, nums, res, curRes);
        // 加这个数
        curRes.add(nums[idx]);
        helper(idx + 1, nums, res, curRes);
        curRes.remove(curRes.size() - 1);
    }
}
/**
 * 
[]
├── [1]
│   ├── [1,2]
│   │   └── [1,2,3]
│   └── [1,3]
├── [2]
│   └── [2,3]
└── [3]
[]
[1]
[1,2]
[1,2,3]
[1,3]
[2]
[2,3]
[3]
Time complexity is O(n · 2^n) because there are 2^n subsets and each subset takes O(n) time to copy.
Space complexity is also O(n · 2^n) due to storing all subsets, and the recursion stack itself is O(n).
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, nums, res, new ArrayList<>());
        return res;
    }
    private void helper(int start, int[] nums, List<List<Integer>> res, List<Integer> curRes) {
        res.add(new ArrayList<>(curRes));
        // 每一层调用helper几次， 就是有几个叉
        for (int i = start; i < nums.length; i++) {
            curRes.add(nums[i]);
            helper(i + 1, nums, res, curRes);
            curRes.remove(curRes.size() - 1);
        }
    }
}
