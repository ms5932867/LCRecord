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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) {
            return res;
        }

        getHeight(root);
        return res;
    }
    private int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int curHeight;
        if (node.left == null && node.right == null) {
            curHeight = 0;  
        } else {
            curHeight = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
        while (res.size() <= curHeight) {
            res.add(new ArrayList<>());
        }
        System.out.println(curHeight + " " + node.val);
        res.get(curHeight).add(node.val);
        return curHeight;
    }
}