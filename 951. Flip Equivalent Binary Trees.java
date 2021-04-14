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
//     public boolean flipEquiv(TreeNode root1, TreeNode root2) {
//         if (root1 == null && root2 == null) {
//             return true;
//         }
//         if (root1 == null || root2 == null || root1.val != root2.val) {
//             return false;
//         }
//         return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) 
//             || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
//     }
// }

//让树中所有节点的左孩子都小于右孩子，如果当前不满足就翻转。我们把这种状态的二叉树称为 标准态。所有等价二叉树在转换成标准态后都是完全一样的。

// 算法

// 用深度优先遍历来对比这两棵树在标准态下是否完全一致。对于两颗等价树，在标准态下遍历的结果一定是一样的。

// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/flip-equivalent-binary-trees/solution/fan-zhuan-deng-jie-er-cha-shu-by-leetcode/
// 注意 null 要用-1 占位
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        List<Integer> res1 = new ArrayList<>();
        dfs(root1, res1);
        List<Integer> res2 = new ArrayList<>();
        dfs(root2, res2);
        return res1.equals(res2);
    }
    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left == null) {
            root.left = new TreeNode(-1);
        }
        if (root.right == null) {
            root.right = new TreeNode(-1);
        }
        if (root.left.val < root.right.val) {
            dfs(root.left,res);
            dfs(root.right,res);
        } else {
            dfs(root.right,res);
            dfs(root.left,res);
        }
    }
}