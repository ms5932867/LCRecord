// recursion
// if digit -> build cnt and start next level recursion
// if letter ->  add to current result
// if ] -> return from current level
class Solution {
    int index = 0;
    public String decodeString(String s) {
        StringBuilder curRes = new StringBuilder();
        for (;index < s.length(); index++) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                // the index now is for the first digit of the number
                int cnt = getCnt(s);
                // the index now is at [
                String next = decodeString(s);
                for ( ;cnt > 0; cnt--) {
                    curRes.append(next);
                }
                
            } else if (Character.isLetter(c)){
                curRes.append(c);
            } else if (c == ']') {
                return curRes.toString();
            }
        }
        return curRes.toString();
    }
   

    private int getCnt(String s) {
        int cnt = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            cnt = cnt * 10 + (s.charAt(index) -'0');
            index++;
        }
        return cnt; // the index now is at [
    }
}
// stack
class Solution {
    int index = 0;
    Stack<String> stk = new Stack<>();
    public String decodeString(String s) {
        
        for (index = 0;index < s.length(); index++) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                int cnt = getCnt(s);
                stk.push(String.valueOf(cnt));
                // the index now is at [
                            
            } else if (Character.isLetter(c)){
                stk.push("" + c);
            } else if (c == ']') {
                StringBuilder cur = getString();
                String tmp = cur.toString();
                int cnt = Integer.valueOf(stk.pop());
                while(cnt > 1) {
                    cur.append(tmp);
                    cnt--;
                }
                stk.push(cur.toString());
            }
        }
        StringBuilder cur = getString();
        cur.reverse();
        return cur.toString();
    }
    private int getCnt(String s) {
        int cnt = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            cnt = cnt * 10 + (s.charAt(index) -'0');
            index++;
        }
        return cnt; // the index now is at [
    }
    private StringBuilder getString() {
        StringBuilder cur = new StringBuilder();
        while (!stk.isEmpty() && Character.isLetter(stk.peek().charAt(0))) {
            cur.append(stk.pop());
        }
        return cur;
    }
}