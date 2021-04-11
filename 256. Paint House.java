// 3 color r 0, b 1 g 2
// house i costs[i][j] + min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) i > 0
// i = 0 dp[0][0,1,2] = costs[0][0,1,2]
// min{dp[n - 1][0,1,2]}
        
//对于每一个房子， 它的cost取决于前一个房子，遍历当前房子的每一个颜色， 找到前一个房子不凃这个颜色的最小值。

class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        // house 0 costs will not change
        for (int i = 1; i < costs.length; i++) {

            for (int k = 0; k < 3; k++) {
                int paintIwithK = Math.min(costs[i -1][(k + 1) % 3], costs[i -1][(k + 2) % 3]);
                costs[i][k] += paintIwithK;
            }
        }
        
        return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
    }
}