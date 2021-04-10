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
//dfs
// class Solution {
//     public int maxDepth(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
//         return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//     }
// }

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int d = 1;
        int max = 1;
        Stack<TreeNode> stk = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        TreeNode p = root;
        while(!stk.isEmpty() || p != null) {
            if (p != null) {
                max = Math.max(max, d);
                stk.push(p);
                depth.push(d);
                p = p.left;
                d++;
                
            } else {
                p = stk.pop().right;
                d = depth.pop()+ 1;
            }
        }
        return max;
        
    }
}