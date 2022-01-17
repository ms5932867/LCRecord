// Solution 1: without Stack, Space O(1)
class Solution {
    public int calculate(String s) {
        int res = 0;
        int lastNum = 0;
        char lastOp = '+';
        
        String ops = "+-*/";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (ops.contains(s.charAt(i) + "")) {
                lastOp = s.charAt(i);
                continue;
            }
            int curNum = 0;
            while(i < s.length() && Character.isDigit(s.charAt(i))) {
                curNum = curNum * 10 + (s.charAt(i) - '0');
                i++;
            }
            i--;
            if (lastOp == '+') {
                res += curNum;
                lastNum = curNum;
            } else if (lastOp == '-') {
                res -= curNum;
                lastNum = curNum * (-1);
            } else if (lastOp == '*') {
                res = res - lastNum + lastNum * curNum;
                lastNum = lastNum * curNum;
            } else {
                res = res - lastNum + lastNum / curNum;
                lastNum = lastNum / curNum;
            } 

            
        }
        return res;
    }
}
// Solution 2: with Stack, Space O(n)
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
                i--; // IMPORTANT!!! because i is the next index of the number
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