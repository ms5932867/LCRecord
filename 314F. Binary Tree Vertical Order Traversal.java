import java.util.Map;
// Solution 1: BFS without sorting
// Time Complexity:O(n) Space Complexity:O(n) 
class Solution {
    class NodePos{
        TreeNode node;
        int c;
        NodePos(TreeNode node, int c) {
            this.node = node;
            this.c = c;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Integer>> cToNodePos = new HashMap<>();
        Queue<NodePos> q = new LinkedList<>();
        q.offer(new NodePos(root, 0));
        int minC = 0;
        while(!q.isEmpty()) {
            for (int s = q.size(); s > 0; s--) {
                NodePos cur = q.poll();
                minC = Math.min(minC, cur.c);
                cToNodePos.putIfAbsent(cur.c, new ArrayList<>());
                cToNodePos.get(cur.c).add(cur.node.val);
                if (cur.node.left != null) {
                    q.offer(new NodePos(cur.node.left, cur.c - 1));
                }
                if (cur.node.right != null) {
                    q.offer(new NodePos(cur.node.right, cur.c + 1));
                }   
            }
        }
        
        while(cToNodePos.containsKey(minC)) {
            res.add(cToNodePos.get(minC));
            minC++;
        }
        return res;
    }
}

// Solution 2: DFS READ: 
// https://leetcode.com/problems/binary-tree-vertical-order-traversal/solution/
// Compared to the DFS traversal, the BFS traversal gives us a head start, since the nodes in higher rows would be visited later than the ones in the lower lows. As a result, we only need to focus on the column order.

// That being said, we could simply traverse the tree in any DFS order (preorder, inorder or postorder), then we sort the resulting list strictly based on two keys <column, row>, which would give us the same results as the BFS traversal.