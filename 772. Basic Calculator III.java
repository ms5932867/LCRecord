class Solution {
    // + - * / ()
    public int calculate(String s) {
        s = "(" + s + ")";
        return helper(s);
    }
    // calculate the result inside a pair of ()
    // i is the index of left (
    int index = 0;
    
    private int helper(String s) { 
        char preOps = '+';
        Stack<Integer> stk = new Stack<>();
        
        for (index = index + 1; index < s.length(); index++) {
            if (s.charAt(index) == ' ') {
                continue;
            }
            if (Character.isDigit(s.charAt(index))) {
                int curVal = 0;
                while(index < s.length() && Character.isDigit(s.charAt(index))) {
                    curVal = curVal * 10 + (s.charAt(index) - '0');
                    index++;
                }
                calculate(stk, curVal, preOps);
                index--;
            }
            else {
                if (s.charAt(index) == '(') {
                    int nextRes = helper(s);
                    calculate(stk, nextRes, preOps);
                }
                else if (s.charAt(index) == ')') {
                    // index++;
                    break;
                }
                else {
                    preOps = s.charAt(index);
                }
            }
        }
        int res = 0;
        while (!stk.isEmpty()) {
            res += stk.pop();
        }
        return res;
    }
    private void calculate(Stack<Integer> stk, int curVal, char preOps) {
        if (preOps == '+') {
            stk.push(curVal);
        }
        else if (preOps == '-') { 
            stk.push(curVal * (-1));
        }
        else if (preOps == '*') { 
            stk.push(stk.pop() * curVal);
        }
        else {
            stk.push(stk.pop() / curVal);
        }
    }
}