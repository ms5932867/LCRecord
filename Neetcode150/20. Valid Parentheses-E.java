
/**
 * 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
*/
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> rightToLeft = new HashMap<>();
        rightToLeft.put( ')', '(');
        rightToLeft.put( ']', '[');
        rightToLeft.put( '}', '{');

        Stack<Character> stk = new Stack<>();
        // Deque<Character> stk = new ArrayDeque<>(); 
        for (char c: s.toCharArray()) {
            if (!rightToLeft.containsKey(c)) {
                stk.push(c);
            } else {
                if (stk.isEmpty()) {
                    return false;
                } else {
                    char last = stk.pop();
                    if (last != rightToLeft.get(c)) {
                        return false;
                    }
                }
            }
        }
        return stk.isEmpty();
    }
}
