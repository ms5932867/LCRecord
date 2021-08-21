import java.util.Map;
// bfs
// check      otherwise null pointer           
//  if (!preToNext.containsKey(cur)) {
//     continue;
// }
// where semester++
//TODO : DFS: https://www.cnblogs.com/lz87/p/11280484.html
class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, Set<Integer>> preToNext = new HashMap<>();
        Map<Integer, Integer> nextToPreCnt = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            nextToPreCnt.put(i, 0);
        }
        for (int[] rlt : relations) {
            preToNext.putIfAbsent(rlt[0], new HashSet<>());
            preToNext.get(rlt[0]).add(rlt[1]);
            nextToPreCnt.put(rlt[1], nextToPreCnt.get(rlt[1]) + 1);
        }
        int taken = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int next : nextToPreCnt.keySet()) {
            if (nextToPreCnt.get(next) == 0) {
                q.offer(next);
                taken++;
            }
        }
        int semester = 0;
        while (!q.isEmpty()) {
            for (int s = q.size(); s > 0; s--) {
                int cur = q.poll();
                if (!preToNext.containsKey(cur)) {
                    continue;
                }
                for (int next : preToNext.get(cur)) {
                    nextToPreCnt.put(next, nextToPreCnt.get(next) - 1);
                    if (nextToPreCnt.get(next) == 0) {
                        q.offer(next);
                        taken++;
                    }
                }
            }
            semester++;
        }
        return taken == n? semester: -1;
        
    }
}