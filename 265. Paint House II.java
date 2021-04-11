class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        // house 0 color cost will not change
        // we need to find the min and second min 
        /* Firstly, we need to determine the 2 lowest costs of
         * the first row. We also need to remember the color of
         * the lowest. */
        for (int i = 1; i < costs.length; i++) {
            int[] colorAndMinCost = new int[]{-1, Integer.MAX_VALUE};
            int secondMin = Integer.MAX_VALUE;

            for (int k = 0; k < costs[0].length; k++) {
                //  cost paint house i with color k costs[i][k]
                // find the min and second min of costs[i-1][0 ~ k]
                if (costs[i - 1][k] <= colorAndMinCost[1]) {
                    secondMin = colorAndMinCost[1];
                    colorAndMinCost[0] = k;
                    colorAndMinCost[1] = costs[i - 1][k];   
                } else if (costs[i - 1][k] < secondMin) {
                    secondMin = costs[i - 1][k];
                }
            }

            // System.out.println(i + " " + colorAndMinCost[0] + " " + colorAndMinCost[1] + " " + secondMin);
            for (int k = 0; k < costs[0].length; k++) {
                if (k == colorAndMinCost[0]) {
                    costs[i][k] += secondMin; 
                } else {
                    costs[i][k] += colorAndMinCost[1];
                }
            }


        }
        int res = Integer.MAX_VALUE;
        for (int k = 0; k < costs[0].length; k++) {
            res = Math.min(res, costs[costs.length - 1][k]);
        }
        return res;
    }
}