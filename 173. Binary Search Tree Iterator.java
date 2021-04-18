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
class BSTIterator {
    Stack<TreeNode> stk;
    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
        buildStk(root);
    }
    
    private void buildStk(TreeNode root) {
        if (root == null) {
            return;
        }
        stk.push(root);
        while (root.left != null) {
            stk.push(root.left);
        }
    }

    public int next() {
        
    }
    
    public boolean hasNext() {
        if (stk.isEmpty()) {
            return false;
        }
        TreeNode tmp = stk.pop();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */