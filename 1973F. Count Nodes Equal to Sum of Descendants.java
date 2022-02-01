class Solution {
    int cnt = 0;
    public int equalToDescendants(TreeNode root) {
        helper(root);
        return cnt;
    }
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        if (left + right == node.val) {
            cnt++;
        }
        return left + right + node.val;
        
    }
}