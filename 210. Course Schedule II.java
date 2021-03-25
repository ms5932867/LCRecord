import java.util.Map;
class Solution {
    //For example, the pair [0, 1], 
    //indicates that to take course 0 you have to first take course 1.
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] remainPres = new int[numCourses];
        Map<Integer, Set<Integer>> preAndNext =  new HashMap<>();
        int[] res = new int[numCourses];
        for (int[] pair : prerequisites) {
            int pre = pair[1];
            int next = pair[0];
            preAndNext.putIfAbsent(pre, new HashSet<>());
            preAndNext.get(pre).add(next);
            remainPres[next]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int cntTaken = 0;
        for (int i = 0 ; i < numCourses; i++) {
            if (remainPres[i] == 0) {
                q.offer(i);
            }
        }
        System.out.println(q.size());
        if (q.isEmpty()) {
            return new int[0];
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[cntTaken] = cur;
            cntTaken++;
            if (!preAndNext.containsKey(cur)) {
                continue;
            }
            for (int next : preAndNext.get(cur)) {
                remainPres[next] --;
                if (remainPres[next] == 0) {
                    q.offer(next);
                }
            }
        }
        if (cntTaken == numCourses) {
            return res;
        }
        return new int[0];
    }
}