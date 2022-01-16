//TODO https://www.youtube.com/watch?v=v05R1OIIg08
// Solution 2
// extra space to save the expression string and calculate the result at the end
class Solution {
    
    List<String> res = new ArrayList<>();
    Set<Character> operators = new HashSet<>(Arrays.asList(new Character[]{'+', '-', '*'}));
    int target;
    
    public List<String> addOperators(String num, int target) {
        this.target = target;
        if (num == null || num.length() == 0) {
            return res;
        }
        
        dfs(num, new StringBuilder(), 0);
        return res;
    }
    private void dfs(String num, StringBuilder ops, int index) {
        
        if (index == num.length()) {
            if (calculate(ops.toString())) {
                res.add(new String(ops.toString()));
            }
            return;
        }

        ops.append(num.charAt(index));
        dfs(num, ops, index + 1);
        ops.deleteCharAt(ops.length() - 1);

        
        
        // operators cannot be the first or continous operators
        if ( ops.length() != 0 && Character.isDigit(ops.charAt(ops.length() - 1))) { // how about the last digit????
            for (char c: operators) {
                ops.append(c);
                dfs(num, ops, index);
                ops.deleteCharAt(ops.length() - 1);
            }
        }

        
    }
    private boolean calculate(String ops) {
        Stack<Double> stk = new Stack<>();
        char lastOp = '+';
        for (int i = 0; i < ops.length(); i++) {
            if (!Character.isDigit(ops.charAt(i))) {
                lastOp = ops.charAt(i);
                continue;
            }
            
            double curNum = 0;
            while (i < ops.length() && Character.isDigit(ops.charAt(i))) {
                if (ops.charAt(i) == '0' && curNum == 0 && (i < ops.length() - 1  && Character.isDigit(ops.charAt(i + 1)))) {
                    return false;
                }
                curNum = curNum * 10 + (double)(ops.charAt(i) - '0');
                i++;
            }
            if (lastOp == '+') {
                stk.push(curNum);
            } else if (lastOp == '-') {
                stk.push(curNum * (-1));
            } else if (lastOp == '*') {
                double last = stk.pop();
                stk.push(curNum * last);
            }
            lastOp = '+';
            i--;
            
        }
        double sum = 0;
        while(!stk.isEmpty()) {
            sum += stk.pop();
        }
        // System.out.println(ops + "=" + sum);
        return sum  == target;
    }
}