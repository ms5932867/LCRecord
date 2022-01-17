// https://www.cnblogs.com/grandyang/p/4944875.html
// https://zxi.mytechroad.com/blog/searching/leetcode-301-remove-invalid-parentheses/
// Solution 2: bfs
class Solution {
    Set<String> validStr = new HashSet<>();
    Set<String> invalidStr = new HashSet<>();
    List<String> res = new ArrayList<>();
    Set<String> set =  new HashSet<>();
    Set<String> used =  new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        
        if (isValid(s)) {
            res.add(s);
            return res;
        } 
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        while(!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) {
                String cur = q.poll();
                if (used.contains(cur)) {
                    continue;
                }
                used.add(cur);
                for (int i = 0; i < cur.length(); i++) {
                    char c = cur.charAt(i);
                    if (Character.isLetter(c)) {
                        continue;
                    }
                    String next = cur.substring(0, i) + cur.substring(i + 1, cur.length());
                    if (isValid(next)) {
                        set.add(next);
                    } else {
                        q.offer(next);
                    }
                }
            }
            if (!set.isEmpty()) { //IMPORTANT!!!
                break;
            }
            
        }
        return new ArrayList<>(set);
    }
    private boolean isValid(String s) {
        if (validStr.contains(s)) {
            return true;
        }
        if (invalidStr.contains(s)) {
            return false;
        }
         
        int left = 0;
        int right = 0;
        for (char c :  s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                right++;
            }
            if (left < right) {
                invalidStr.add(s);
                return false;
            }
        }
        if (left == right) {
            validStr.add(s);
            return true;
        }
        invalidStr.add(s);
        return false;
    }
}


// Solution 1 dfs needs optimization
class Solution {
    boolean[] used;
    Set<String> set;
    public List<String> removeInvalidParentheses(String s) {
        set = new HashSet<>();
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        int cnt = findMinSteps(s);
        dfs(s, new StringBuilder(), cnt, 0, 0);
        return new ArrayList<>(set);
    }
    private void dfs(String s, StringBuilder cur, int remain, int index, int dif) { // dif is cnt different of ( - )
        if (index == s.length()) {
            if (remain == 0 && dif == 0) {
                set.add(cur.toString());
            }
            return;
        }
        if (remain < 0 || dif < 0) {
            return;
        }
        
        char c = s.charAt(index);
        if (Character.isLetter(c)) {
            cur.append(c);
            // used[index] = true;
            dfs(s, cur, remain, index + 1, dif);
            cur.deleteCharAt(cur.length() - 1);
        } else if (c == '(') {
            // keep '('
            cur.append(c);
            dfs(s, cur, remain, index + 1, dif + 1);
            cur.deleteCharAt(cur.length() - 1);
            
            // do not use '('
            dfs(s, cur, remain - 1, index + 1, dif);
            
        } else {
            // keep ')'
            cur.append(c);
            dfs(s, cur, remain, index + 1, dif - 1);
            cur.deleteCharAt(cur.length() - 1);

            // do not use ')'
            dfs(s, cur, remain - 1, index + 1, dif);
        }
        
    }
    private int findMinSteps(String s) {
        
        Stack<Character> stk = new Stack<>();
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stk.push(c);
            } else if (c == ')') {
                if (stk.isEmpty()) {
                    cnt++;
                } else {
                    stk.pop();
                }
            }
        }
        return cnt + stk.size();
    }
}