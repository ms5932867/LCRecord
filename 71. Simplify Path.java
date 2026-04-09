
class Solution {
    public String simplifyPath(String path) {
        Stack<String> dir = new Stack<>();
        for (String p : path.split("/")) {
            if (p == null || p.length() == 0 || p.equals(".")) {
                continue;
            }
            if (p.equals("..")) {
                if (!dir.isEmpty()) {
                   dir.pop(); 
                }
                continue;
            }
            dir.push(p);
        }
        StringBuilder res = new StringBuilder();
        res.append("/");
        if (dir.isEmpty()) {
            return res.toString();
        }
        for (String p : dir) {
            res.append(p); 
            res.append("/");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}