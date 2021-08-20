// DFS TLE
// class Solution {
//     int minRes = Integer.MAX_VALUE;
//     public int minimumTotal(List<List<Integer>> triangle) {
//         dfs(triangle,0,0,0);
//         return minRes;
//     }
//     private void dfs(List<List<Integer>> triangle, int row, int col, int curSum) {
//         if (row == triangle.size()) {
//             minRes = Math.min(minRes, curSum);
//             return;
//         }
//         if (col >= triangle.get(row).size()) {
//             return;
//         }
//         dfs(triangle, row + 1, col, curSum + triangle.get(row).get(col));
//         dfs(triangle, row + 1, col + 1, curSum + triangle.get(row).get(col));
//     }
// }
// DP with extra space
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            res.add(new ArrayList<>());
        }
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == triangle.size() - 1) {
                    res.get(i).add(triangle.get(i).get(j));
                    continue;
                }
                res.get(i).add(triangle.get(i).get(j) + Math.min(res.get(i + 1).get(j), res.get(i + 1).get(j+ 1)));
            }
        }
        return res.get(0).get(0);
    }
}
// DP inplace
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i).get(j) +  triangle.get(i - 1).get(j));
                    continue;
                } else if (j == triangle.get(i).size() - 1) {
                    triangle.get(i).set(j, triangle.get(i).get(j) +  triangle.get(i - 1).get(j - 1));
                    continue;
                }
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < triangle.get(triangle.size() - 1).size(); j++) {
            res = Math.min(res, triangle.get(triangle.size() - 1).get(j));
        }
        return res;
    }
}