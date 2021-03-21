class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Arrays.fill(visited, false);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] =true;
        int remain = rooms.size() - 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : rooms.get(cur)) {
                if (!visited[next]) {
                    q.offer(next);
                    remain--;
                    visited[next] = true;
                }
            }
        }
        return remain == 0;
    }
}