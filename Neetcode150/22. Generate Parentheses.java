/*
22. Generate Parentheses
*/
/* 
time: This is a backtracking problem. The time complexity is proportional to the number of valid outputs, and each output takes O(n) to construct.
The number of valid combinations is given by the Catalan number, which grows exponentially.
Time complexity is O(4^n / √n), which corresponds to the number of valid parentheses combinations (Catalan number). Each string takes O(n) to build.
Space complexity is O(n) for recursion stack, excluding the output.
*/



class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        dfs(n, cur, 0, 0, res);
        return res;
    }
    private void dfs(int n, StringBuilder cur, int left, int right, List<String> res) {
        if (cur.length() == 2 * n && left == right) {
            res.add(cur.toString());
            return;
        }
        if (left < n) {
            cur.append('(');   
            dfs(n, cur, left + 1, right, res);
            cur.deleteCharAt(cur.length() - 1);
        }
        
        if (left > right) {
            cur.append(')');
            dfs(n, cur, left, right + 1, res);
            cur.deleteCharAt(cur.length() - 1);
        }
        
    }
}
