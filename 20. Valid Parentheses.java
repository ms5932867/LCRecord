import java.util.*;
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
class Solution {
    public boolean isValid(String s) {
       Stack<Character> stk = new Stack<>();
       Map<Character, Character> pair = new HashMap<>();
       pair.put(')', '(');
       pair.put(']', '[');
       pair.put('}', '{');
       for (char c : s.toCharArray()) {
            if (!pair.containsKey(c)) {
                stk.push(c);
            } else if (stk.isEmpty() || pair.get(c) != stk.pop()){
                return false;
            }
       }
       return stk.isEmpty();
    }
}