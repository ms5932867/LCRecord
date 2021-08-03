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
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                sb.append("null");
            } else {
                sb.append(String.valueOf(cur.val));
                q.offer(cur.left);
                q.offer(cur.right);
            }
            sb.append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }
        int index = 0;
        String[] dataAry = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(dataAry[index]));
        index++;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty() && index < dataAry.length) {
            TreeNode cur = q.poll();
            if (dataAry[index].equals("null")) {
                cur.left = null;
            } else {
                cur.left = new TreeNode(Integer.valueOf(dataAry[index]));
                q.offer(cur.left);
            }
            index++;
            if (index < dataAry.length && dataAry[index].equals("null")) {
                cur.right = null;
            } else {
                cur.right = new TreeNode(Integer.valueOf(dataAry[index]));
                q.offer(cur.right);
            }
            index++;

        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));



----------------------------------------------------------
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
        return serializeHelper(root, "");

    }
    private String serializeHelper(TreeNode root, String data) {
        if (root == null) {
            data += "null,";
            return data;
        }
        data + = String.valueOf(root.val) + ",";
        data += serializeHelper(root.left, data);
        data += serializeHelper(root.right, data);
        return data;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeHelper()
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));