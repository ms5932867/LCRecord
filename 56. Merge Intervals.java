
//list to array: res.toArray(new int[res.size()][2]);
// Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        for (int[] itv :intervals) {
            if (res.size() == 0 || res.get(res.size() - 1)[1] < itv[0]) {
                res.add(itv);
            }
            else {
                int[] last = res.get(res.size() - 1);
                int[] next =  new int[]{Math.min(last[0], itv[0]), Math.max(last[1], itv[1])};
                res.remove(res.size() - 1);
                res.add(next);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
