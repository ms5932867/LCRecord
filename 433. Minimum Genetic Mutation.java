class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);
        int step = 0;
        while(!q.isEmpty()) {
            for (int i = q.size(); i > 0; i-- ){
                String cur = q.poll();
                if (cur.equals(end)) {
                    return step;
                }
                for (String next : bank) {
                    if (validNext(visited, cur, next)) {
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    private boolean validNext(Set<String> visited, String cur, String next) {
        if (visited.contains(next) || cur.length() != next.length()) {
            return false;
        }
        int dif = 0;
        for(int i = 0; i < cur.length(); i++) {
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