// Solution1 Time O(n) Space O(n)
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

// Solution2 Time O(n) Space O(1)
// https://www.cnblogs.com/grandyang/p/15515997.html
/**
 * 我们也可以优化一下空间复杂度，不用栈了，而是用两个变量 left 和 right，
 * 分别表示左右括号的个数，
 * 先遍历一遍给定字符串s，统计出所有的右括号的个数。
 * 然后再次遍历给定字符串s，
 * 若遇左扩号了，
 * 判断若此时 left 和 right 相等了，说明后面没有多余的右括号了，
 * 此时的左括号就是非法的，则直接跳过，否则就让 left 自增1。
 * 若遇到右括号了，则 right 先自减1，
 * 因为 right 表示的是后面还有的右括号的个数，
 * 若此时 left 等于0了，说明前面没有对应的左括号了，则直接跳过，否则 left 自减1。
 * 对于所有没有 continue 的情况，则均加入到结果 res 中，
 * 表示对应的字母，或者左右括号就是合法的，
 * 
 */
class Solution {
    public String minRemoveToMakeValid(String s) {
        int r = 0;
        for (char c: s.toCharArray()) {
            if (c ==')') {
                r++;
            }
        }
        int l = 0;
        // l: how many left ( needs to be paired
        // r: how many right ) can be used to pair
        StringBuilder res = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (Character.isLetter(c)) {
                res.append(c);
            } else if (c == '(') {
                l++;
                if (l <= r) {
                    res.append(c);
                }
            } else {
                if (l > 0) {
                    res.append(c);
                    l--;
                }
                r--; 
            }
        }
        return res.toString();
    }
}
