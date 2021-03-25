class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int step = 1;
        if (wordList == null || wordList.size() == 0 ) {
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        q.offer(beginWord);
        visited.add(beginWord);

        while (!q.isEmpty()) {
            for (int s = q.size(); s > 0 ; s--) {
                String cur = q.poll();
                if (cur.equals(endWord)) {
                    return step;
                }
                for (String next : wordList) {
                    if (validate(cur, next, visited)) {
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    private boolean validate(String cur, String next, Set<String> visited) {
        if (visited.contains(next)) {
            return false;
        }
        if (next == null || cur.length() != next.length()) {
            return false;
        }
        int dif = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != next.charAt(i)) {
                dif++;
                if (dif > 1) {
                    return false;
                }
            }
        }
        return dif == 1;
    }
}