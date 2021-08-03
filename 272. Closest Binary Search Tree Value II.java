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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> nums = inorder(root);
        quickSort(nums, target, k, 0, nums.size() - 1);
        return nums.subList(0, k);
    }
    private void quickSort(List<Integer> nums, double target, int k, int start, int end) {
        if (start > end) {
            return;
        }
        int pivot = end;
        int i = start;
        int j = end - 1;
        double pivotDif = Math.abs((double)nums.get(pivot) - target);
        while (i <= j) {
            if (Math.abs((double)nums.get(i) - target) < pivotDif) {
                i++;
            } else {
                swap(nums, i, j);
                j--;
            }
        }

        swap(nums, i, pivot);
        if (i == k - 1) {
            return;
        } else if (i > k - 1) {
            quickSort(nums, target, k, start, i - 1);
        } else {
            quickSort(nums, target, k, i + 1, end);
        }
    }
    private void swap(List<Integer> nums, int a, int b) {
        int tmp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, tmp);
    }
    private List<Integer> inorder(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        if (root == null) {
            return nums;
        }
        Stack<TreeNode> stk = new Stack<>();
        TreeNode p = root;
        while(!stk.isEmpty() || p != null) {
            while (p != null) {
                stk.push(p);
                p = p.left;
            }
            p = stk.pop();
            nums.add(p.val);
            p = p.right;
        }
        return nums;
    }
}


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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k,(i1,i2) -> Double.compare(Math.abs((double)i2 - target), Math.abs((double)i1 - target)));
        dfs(root, k, pq);
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            res.add(pq.poll());
        }
        return res;
    }
    private void dfs(TreeNode node, int k, PriorityQueue<Integer> pq) {
        if (node == null) {
            return;
        }
        dfs(node.left, k, pq);
        pq.offer(node.val);
        if (pq.size() > k) {
            pq.poll();
        }
        dfs(node.right, k, pq);
    }

}