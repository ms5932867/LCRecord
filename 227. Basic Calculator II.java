class Solution {
    // + - * /
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        char preOperator = '+';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (Character.isDigit(s.charAt(i))) {
                int curVal = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    curVal = curVal * 10 + (s.charAt(i) - '0');
                    i++;
                }
                if (preOperator == '+') {
                    stk.push(curVal);
                }else if (preOperator == '-') {
                    stk.push(curVal * (-1));
                }else if (preOperator == '*') {
                    stk.push(stk.pop() * curVal);
                }else if (preOperator == '/') {
                    stk.push(stk.pop() / curVal);
                }
                i--; // because i is the next index of the number
            }
            else {
                preOperator = s.charAt(i);
            }
        }
        int res = 0;
        while (!stk.isEmpty()) {
            res += stk.pop();
        }
        return res;
    }
}