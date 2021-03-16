// class Solution {
//     public int[][] merge(int[][] intervals) {
//         Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
//         List<int[]> res = new ArrayList<>();
//         int[] last = null;
//         for (int[] cur : intervals) {
//             if (last == null) {
//                 last = cur;
//             } else {
//                 if (last[1] >= cur[0]) {
//                     last[1] = Math.max(last[1], cur[1]);
//                 }
//                 else {
//                     res.add(last);
//                     last = cur;
//                 }
//             }
//         }
//         res.add(last);//每一个被加到result 都是这个跟之后的判断，发现之后的开始大于这个的结束，
//         // 这个就被加到result。 但是最后那一个没有机会进入这样的判断

//         int[][] ans = new int[res.size()][2];
//         for (int n = 0; n < res.size(); n++) {
//             ans[n] = res.get(n);
//         }
//         return ans;
//     }
// }
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
        int[][] ans = new int[res.size()][2];
        for (int n = 0; n < res.size(); n++) {
            ans[n] = res.get(n);
        }
        return ans;
    }
}