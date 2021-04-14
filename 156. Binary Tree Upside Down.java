// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public TreeNode upsideDownBinaryTree(TreeNode root) {
//         if (root == null) {
//             return null;
//         }
//         if (root.left == null && root.right == null) {
//             return root;
//         }
//         TreeNode newRoot = upsideDownBinaryTree(root.left);
//         root.left.left = root.right;
//         root.left.right = root;
//         root.left = null;
//         root.right = null;
//         return newRoot;
//     }
    
// }
// beloew is copied from  https://www.cnblogs.com/grandyang/p/5172838.html
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {

        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode next = null;
        TreeNode tmp = null;

        while (cur != null) {
            next = cur.left;
            cur.left = tmp;
            tmp = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
}