/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return root;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if (root.val < q.val && root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > q.val && root.val > p.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return root;
        }
        
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.val > p.val && node.val > q.val) {
                node = node.left;
            } else if (node.val < p.val && node.val < q.val) {
                node = node.right;
            } else {
                return node;
            }

        }
        return null;
    }
}