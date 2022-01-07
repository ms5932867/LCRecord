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
    public boolean isCompleteTree(TreeNode root) {
        boolean reachNull = false;
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) {
                TreeNode cur = q.poll();
                if (reachNull && cur.left != null) { 
                    return false;
                }
                if (cur.left == null) {
                    reachNull = true;
                } else {
                    q.offer(cur.left);
                }
                if (reachNull && cur.right != null) { 
                    return false;
                }
                if (cur.right == null) {
                    reachNull = true;
                } else {
                    q.offer(cur.right);
                }
                
            }
        }
        return true;
    }
}