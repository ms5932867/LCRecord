//treemap
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();// int : cnt
        for (int n: nums) {
            tm.putIfAbsent(n, 0);
            tm.put(n, tm.get(n) + 1);
        }
        int cnt = 0;
        int lastNum = -1;
        while(tm.size() > 0) {
            if (cnt == k) {
                cnt = 0;
            }
            if (cnt == 0) {
                lastNum = tm.firstKey();
            } else if (cnt < k) {
                if (!tm.containsKey(lastNum + 1)) {
                    return false;
                }
                lastNum++;
            } 
            tm.put(lastNum, tm.get(lastNum) - 1);
            if (tm.get(lastNum) == 0) {
                tm.remove(lastNum);
            }
            cnt++;
        }
        return cnt == k;
    }
}