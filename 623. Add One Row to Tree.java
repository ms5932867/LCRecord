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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            d--;
            for (int s = q.size(); s > 0; s--) {
                TreeNode cur = q.poll();
                if (d == 1) {
                    
                    TreeNode curLeft = cur.left;
                    TreeNode curRight = cur.right;
                    cur.left = new TreeNode(v);
                    cur.left.left = curLeft;
                    cur.right = new TreeNode(v);
                    cur.right.right = curRight;
                }
                else {
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
            }
        }
        return root;
    }
}