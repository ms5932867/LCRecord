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
//Solution 1
class Solution {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return sum;
    }
    private void helper(TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }
        if (node.val > high) {
            helper(node.left, low, high);
        }
        else if (node.val < low) {
            helper(node.right, low, high);
        } else {
            sum += node.val;
            helper(node.left, low, high);
            helper(node.right, low, high);
        }
    }
}
//Solution 2
class Solution {

    public int rangeSumBST(TreeNode root, int low, int high) {
        return helper(root, low, high);

    }
    private int helper(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }
        if (node.val > high) {
            return helper(node.left, low, high);
        }
        else if (node.val < low) {
            return helper(node.right, low, high);
        } else {
            return node.val + helper(node.left, low, high) + helper(node.right, low, high);
        }
    }
}

//Solution 3
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        int sum = 0;
        while(!stk.isEmpty()) {
            TreeNode cur = stk.pop();
            if (cur != null) {
                if (cur.val > high) {
                    stk.push(cur.left);
                } else if (cur.val < low) {
                    stk.push(cur.right);
                } else {
                    sum += cur.val;
                    stk.push(cur.left);
                    stk.push(cur.right);  
                }
            }
        }
        return sum;
    }
}

//Solution 4
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val >= low && root.val <= high) {
            return root.val += (rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high));
        } else if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return rangeSumBST(root.left, low, high);
    }
}