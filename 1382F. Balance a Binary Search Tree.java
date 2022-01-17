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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        dfs(root, nums);
        if (nums == null) {
            return null;
        }
        return buildTree(nums, 0, nums.size() - 1);       
    }
    private TreeNode buildTree(List<Integer> nums, int s, int e) {
        if (s > e) {
            return null;
        }
        int index = s + (e -s) / 2;
        TreeNode root = new TreeNode(nums.get(index));
        root.left = buildTree(nums, s, index - 1);
        root.right = buildTree(nums, index + 1, e);
        return root;
    }
    
    private void dfs(TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }
        dfs(node.left, nums);
        nums.add(node.val);
        dfs(node.right, nums);
    }
}