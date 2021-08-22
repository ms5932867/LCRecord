// Answer is the max time a leaf node needs to be informed.
// bfs: https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/1381997/Simple-JAVA-solution-using-BFS
// Maximum value of the time array is the total taken time for the information to get reached to every single employee.
// dfs1:  use local virable for time
class Solution {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, Set<Integer>> directManagerToEmployee = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            directManagerToEmployee.putIfAbsent(manager[i], new HashSet<>());
            directManagerToEmployee.get(manager[i]).add(i);
        }
        return dfs(headID, directManagerToEmployee, informTime, 0);

    }
    private int dfs(int cur, Map<Integer, Set<Integer>> directManagerToEmployee, int[] informTime, int curTime) {
        if (!directManagerToEmployee.containsKey(cur)) {
            // reached the bottom of the tree
            return curTime;
        }
        int tmpTime = Integer.MIN_VALUE;
        for (int next : directManagerToEmployee.get(cur)) {
            tmpTime = Math.max(tmpTime, dfs(next, directManagerToEmployee, informTime, curTime + informTime[cur]));
        }
        return tmpTime;
    }
}

// dfs2: use global virable for time
class Solution {
    int time = Integer.MIN_VALUE;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, Set<Integer>> directManagerToEmployee = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            directManagerToEmployee.putIfAbsent(manager[i], new HashSet<>());
            directManagerToEmployee.get(manager[i]).add(i);
        }
        dfs(headID, directManagerToEmployee, informTime, 0);
        return time;
    }
    private void dfs(int cur, Map<Integer, Set<Integer>> directManagerToEmployee, int[] informTime, int curTime) {
        if (!directManagerToEmployee.containsKey(cur)) {
            // reached the bottom of the tree
            time = Math.max(time, curTime);
            return;
        }
        for (int next : directManagerToEmployee.get(cur)) {
            dfs(next, directManagerToEmployee, informTime, curTime + informTime[cur]);
        }
    }
}

