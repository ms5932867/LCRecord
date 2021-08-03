/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

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