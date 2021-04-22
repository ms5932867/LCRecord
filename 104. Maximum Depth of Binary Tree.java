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
        Stack<TreeNode> stk = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        TreeNode p = root;
        int d = 0;
        int max = d;
        while(!stk.isEmpty() || p != null) {
            while(p != null) {
                stk.push(p);
                d++;
                // System.out.println(d);
                depth.push(d);
                max = Math.max(max, d);
                p = p.left;
            }
            
            p = stk.pop();
            d = depth.pop();
            p = p.right;
        }
        return max;
    }
}