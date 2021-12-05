// Solution 1: Space O(1)
class Solution {
    public int minAddToMakeValid(String s) {
        int dif = 0; // left - right
        int cnt = 0;
        for (char c:  s.toCharArray()) {
            if (c == '(') {
                dif++; 
            } else {
                if (dif > 0) {
                    dif--;
                } else {
                    cnt++;
                }
            }
        }
        return cnt + dif;
    }
}

//solution 2 Stack
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c: s.toCharArray()) {
            if (stk.isEmpty() || c == '(') {
                stk.push(c);
            } else { // c == ')'
                if (stk.peek() == '(') {
                    stk.pop();
                } else {
                    stk.push(c);
                }
            }
        }
        return stk.size();
    }
}
//Solution 3: Stack optimized if else logic
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c: s.toCharArray()) {
            if (stk.isEmpty() || c == '(' || (c == ')' && stk.peek() != '(')) {
                stk.push(c);
            } else { 
                stk.pop();
            }
        }
        return stk.size();
    }
} 
