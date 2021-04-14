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
// class Solution {
//     public TreeNode searchBST(TreeNode root, int val) {
//         if (root == null || root.val == val) {
//             return root;
//         }
//         if (root.val > val) {
//             return searchBST(root.left, val);
//         } 
//         return searchBST(root.right, val);
        
//     }
// }
// Approach 2: Iteration
// To reduce the space complexity, one could convert recursive approach into the iterative one:

// While the tree is not empty root != null and the value to find is not here val != root.val:

// If val < root.val - go to search into the left subtree root = root.left.

// If val > root.val - go to search into the right subtree root = root.right.

// Return root.
// Time complexity : \mathcal{O}(H)O(H), where HH is a tree height. That results in \mathcal{O}(\log N)O(logN) in the average case, and \mathcal{O}(N)O(N) in the worst case.
// Space complexity : \mathcal{O}(1)O(1) since it's a constant space solution.
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}