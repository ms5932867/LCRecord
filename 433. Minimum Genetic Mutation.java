class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        
        for (String s : bank) {
            bankSet.add(s);
        }
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        int step = 0;
        while (!q.isEmpty()) {
            for (int s = q.size(); s > 0; s--) {
                String cur = q.poll();
                if (cur.equals(end)) {
                    return step;
                }
                for (String next : bank) {
                    if (bankSet.contains(next) && validate(cur, next)) {
                        q.offer(next);
                        bankSet.remove(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    private boolean validate(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                cnt++;
            }
        }
        return cnt ==1;
    }
}