/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
// Solution 1: Space O(1)
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/discuss/1419627/2-solutions-in-Python-typical-DFS-optimized-O(1)-space

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node tmpP = p;
        Node tmpQ = q;
        while (p != q) {
            if (p == null) {
                p = tmpQ;
            } else {
                p = p.parent;
            }
            if (q == null) {
                q = tmpP;
            } else {
                q = q.parent;
            }
            
        }
        return p;
    }
}

// Solution 2: easy to think
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> pPath = new HashSet<>();
        while (p != null) {
            pPath.add(p);
            p = p.parent;
        }
        while (q != null) {
            if (pPath.contains(q)) {
                return q;
            }
            q = q.parent;
        }
        return null;

    }
}