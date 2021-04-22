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
    int res = Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return res;
        }
        if (Math.abs((double)root.val - target) <= Math.abs((double)res - target)) {
            res = root.val;
        }
        if (root.val >= target) {
            closestValue(root.left, target);
        } else {
            closestValue(root.right, target);
        }
        return res;
    }
}