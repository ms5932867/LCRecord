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
// huahua https://www.youtube.com/watch?v=QXvbRrK1zjY
// 花花讲解： 关键点1： 整个树最小值是root， 
// 关键点2： 如果一个node 的值大于root，那么这个node所有子树都大于root， 所以这样的node不需要继续遍历
// bfs
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        int min = root.val;
        int secondMin = -1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.val != min) {
                if (secondMin == -1) {
                    secondMin = cur.val;
                } else {
                    secondMin = Math.min(secondMin, cur.val);
                }
            }
            if (cur.left != null && cur.val == min) {
                q.offer(cur.left);
            }
            if (cur.right != null && cur.val == min) {
                q.offer(cur.right);
            }

        }
        return secondMin;
    }
}
// dfs
class Solution {
    int secondMin = -1;
    public int findSecondMinimumValue(TreeNode root) {
        int min = root.val;
        dfs(root, min);
        return secondMin;
    }
    private void dfs(TreeNode node, int min) {
        if (node  == null) {
            return;
        }
        if (node.val > min) {
            if (secondMin == -1) {
                secondMin = node.val;
            } else {
                secondMin = Math.min(secondMin, node.val);
            }
        }
        if (node.val == min) {
            dfs(node.left, min);
            dfs(node.right, min);
        }
    }
}