//155. Min Stack

/**
Integer a = -1024;
Integer b = -1024;

System.out.println(a == b);      // false，可能比地址
System.out.println(a.equals(b)); // true，比数值
System.out.println(a >= b);      // true，自动拆箱后比数值
 */
class MinStack {
    Stack<Integer> minStk;
    Stack<Integer> stk;
    public MinStack() {
        minStk = new Stack<>();
        stk = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if (minStk.isEmpty() || val <= minStk.peek()) {
            minStk.push(val);
        } 
    }
    
    public void pop() {
        if (minStk.peek().equals(stk.peek())) {
            minStk.pop();
        }
        
        stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStk.peek();
    }
}
