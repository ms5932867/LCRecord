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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        Stack<TreeNode> stk = new Stack<>();  
        while (cur != null || !stk.isEmpty()) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            cur = stk.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}