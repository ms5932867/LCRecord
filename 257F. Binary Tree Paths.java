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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, res, new ArrayList<>());
        return res;
    }
    private void helper(TreeNode node, List<String> res, List<String> cur) {
        if (node == null) {
            return;
        }
        cur.add(node.val + "");
        if (node.left == null && node.right == null) {
            StringBuilder curRes = new StringBuilder();
            for (String s : cur) {
                curRes.append(s + "->");   
            }
            curRes.deleteCharAt(curRes.length() - 1);
            curRes.deleteCharAt(curRes.length() - 1);
            res.add(curRes.toString());
             cur.remove(cur.size() - 1);
            return;
        }
        if (node.left != null) {
            helper(node.left, res, cur);
        }
        if (node.right != null) {
            helper(node.right, res, cur);
        }
        
        cur.remove(cur.size() - 1);
        
    }
}