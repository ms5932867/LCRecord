// Solution 1
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    private int dfs(TreeNode node, int cur) {
        if (node == null) {
            return 0;// important!!!
        }
        cur = cur * 10 + node.val;
        if (node.left == null && node.right == null) {
            return cur;
        }
        int res =  dfs(node.left, cur) + dfs(node.right, cur);
        return res;
    }
}
// Solution 2
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, new StringBuilder());
        return sum;
    } 
    private void dfs(TreeNode node, StringBuilder cur) {
        if (node == null) {
            return;
        }
        cur.append(String.valueOf(node.val));
        if (node.left == null && node.right == null) {
            sum += Integer.valueOf(cur.toString());
            cur.deleteCharAt(cur.length() - 1); // !!!!THIS LINE IS IMPORTANT!
            return;
        }
        dfs(node.left, cur);
        dfs(node.right, cur);
        cur.deleteCharAt(cur.length() - 1);
    }
}
    
