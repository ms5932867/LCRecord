/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#");
            return sb.toString();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            for (int s = q.size(); s > 0; s--) {
                TreeNode cur = q.poll();
                if (cur == null) {
                    sb.append("#");
                    sb.append(",");
                }
                else {
                    sb.append(cur.val);
                    sb.append(",");
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || (data.length() == 1 && data.equals("#"))) {
            return null;
        }
        String[] dataAry = data.split(",");

        TreeNode root = new TreeNode(Integer.valueOf(dataAry[0]));
        int index = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (dataAry[index + 1].equals("#")) {
                cur.left = null;
            }
            else {
                cur.left = new TreeNode(Integer.valueOf(dataAry[index + 1]));  
                q.offer(cur.left);
            }
            if (dataAry[index + 2].equals("#")) {
                cur.right = null;
            }
            else {
                cur.right = new TreeNode(Integer.valueOf(dataAry[index + 2])); 
                q.offer(cur.right); 
            }
            index += 2;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));