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
    public class Item {
        int row;
        int col;
        int val;
        Item(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public class ItemComparator implements Comparator<Item> {
        public int compare(Item i1, Item i2) {
            if (i1.row == i2.row) {
                return i1.val - i2.val;
            }
            return i1.row - i2.row;
        }
    }
    TreeMap<Integer, List<Item>> treeMap = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        int row = 0;
        int col = 0;
        dfs(root, row, col);
        for (int key : treeMap.keySet()) {
            List<Item> items = treeMap.get(key);
            Collections.sort(items, new ItemComparator());
            List<Integer> vals = new ArrayList<>();
            for (Item i : items) {
                vals.add(i.val);
            }
            res.add(vals);
        }

        return res;
    }
    private void dfs(TreeNode node, int row, int col) {
        if (node == null) {
            return;
        }
        if (!treeMap.containsKey(col)) {
            treeMap.put(col, new ArrayList<>());
        }
        
        treeMap.get(col).add(new Item(row, col, node.val));
        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1, col + 1);
    }

}