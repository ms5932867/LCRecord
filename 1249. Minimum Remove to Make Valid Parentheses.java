class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stk.push(i);
            } else if (c == ')'){ //
                if (stk.isEmpty() || s.charAt(stk.peek()) != '(') {
                    stk.push(i);
                } else {
                    stk.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder(s);
        while(!stk.isEmpty()) {
            sb.deleteCharAt(stk.pop());
        }
        return sb.toString();
    }
}