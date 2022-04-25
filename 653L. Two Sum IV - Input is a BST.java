/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        dfs(root, nums);
        int l = 0;
        int r = nums.size() - 1;
        while (l < r) {
            if (nums.get(l) + nums.get(r) == k) {
                return true;
            }
            if (nums.get(l) + nums.get(r) > k) {
                r--;
            } else {
                l++;
            }
            
        }
        return false;
    }
    private void dfs(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        dfs(root.left, nums);
        nums.add(root.val);
        dfs(root.right, nums);
    }
}