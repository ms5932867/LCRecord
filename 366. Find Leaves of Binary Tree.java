// Use height, 
// if (res.size() == height) {
//     res.add(new ArrayList<>());
// }
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root);
        return res;
    }
    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }
        
        int height = Math.max(dfs(node.left), dfs(node.right)) + 1;
        if (res.size() == height) {
            res.add(new ArrayList<>());
        }
        res.get(height).add(node.val);
        return height;
    }
}