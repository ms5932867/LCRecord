class Solution {
    class Pair {
        char c;
        int n;
        Pair (char c, int n) {
            this.c = c;
            this.n = n;
        }
        
    }
    public String removeDuplicates(String s, int k) {
        if (k == 1) {
            return "";
        }
        Stack<Pair> stk = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (stk.isEmpty() || ch != stk.peek().c) {
                stk.push(new Pair(ch, 1));
            } else {
                Pair last = stk.pop();
                if (last.n + 1 < k) {
                    stk.push(new Pair(ch, last.n + 1));
                } else if (last.n + 1 > k){
                    stk.push(new Pair(ch, last.n + 1 - k));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()) {
            int cnt = stk.peek().n;
            for (int i = 0; i < cnt; i++) {
                sb.insert(0, stk.peek().c);
            }
            stk.pop();
        }
        return sb.toString();
    }
}