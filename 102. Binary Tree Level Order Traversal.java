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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stk = new Stack<>();
        Stack<Integer> height = new Stack<>();
        TreeNode p = root;
        int d = 0;
        while (p != null || !stk.isEmpty()) {
            while ( p != null) {
                d++;
                stk.push(p);
                height.push(d);
                p = p.left;
            }
            p = stk.pop();
            d = height.pop();
            while (res.size() < d) {
                res.add(new ArrayList<>());
            }
            res.get(d - 1).add(p.val);
            p = p.right;
        }
        return res;
    }
}