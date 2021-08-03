//break: https://www.w3schools.com/java/tryjava.asp?filename=demo_switch
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }  
        Stack<Integer> stk = new Stack<>();
        for (String s: tokens) {
            if ("+-*/".contains(s)) {
                int i1 = stk.pop();
                int i2 = stk.pop();
                switch(s) {
                    case "+":
                        stk.push(i2 + i1);
                        break;
                    case "-":  
                        stk.push(i2 - i1);
                        break;
                    case "*":  
                        stk.push(i2 * i1);
                        break;
                    case "/":  
                        stk.push(i2 / i1);
                        break;
                }            
            } else {
                stk.push(Integer.valueOf(s));
            }

        }
        return stk.pop();
    }
}

//version 2
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stk = new Stack<>();
        for (String t:tokens) {
            if (Character.isDigit(t.charAt(t.length() - 1))) {
                stk.push(Integer.valueOf(t));
            } else {
                int num2 = stk.pop();
                int num1 = stk.pop();
                switch (t) {
                    case "+":
                        stk.push(num1 + num2);
                        break;
                    case "-":
                        stk.push(num1 - num2);
                        break;
                    case "*":
                        stk.push(num1 * num2);
                        break;
                    case "/":
                        stk.push(num1 / num2);
                        break;
                }
            }
        }
        return stk.peek();
    }
}