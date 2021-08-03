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

class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
         getHeight(root, res);
        return res;
    }
    private int getHeight(TreeNode node, List<List<Integer>> res) {
        if (node == null) {
            return 0;
        }
        int height = Math.max(getHeight(node.left, res), getHeight(node.right, res)) + 1;
        while (res.size() < height) {
            res.add(new ArrayList<>());
        }
        res.get(height - 1).add(node.val);
        return height;
    }
}