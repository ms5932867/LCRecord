import java.util.Map;

// Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.
// If there isn't any rectangle, return 0.
// Example 1:
// Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
// Output: 4
// Example 2:
// Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
// Output: 2
// 这道题给了我们一堆点的坐标，问能组成的最小的矩形面积是多少，题目中限定了矩形的边一定是平行于主轴的，不会出现旋转矩形的形状。如果知道了矩形的两个对角顶点坐标，求面积就非常的简单了，但是随便取四个点并不能保证一定是矩形，不过这四个点坐标之间是有联系的，相邻的两个顶点要么横坐标，要么纵坐标，一定有一个是相等的，这个特点先记下。策略是，先找出两个对角线的顶点，一但两个对角顶点确定了，其实这个矩形的大小也就确定了，另外的两个点其实就是分别在跟这两个点具有相同的横坐标或纵坐标的点中寻找即可，为了优化查找的时间，可以事先把所有具有相同横坐标的点的纵坐标放入到一个 HashSet 中，使用一个 HashMap，建立横坐标和所有具有该横坐标的点的纵坐标的集合之间的映射。然后开始遍历任意两个点的组合，由于这两个点必须是对角顶点，所以其横纵坐标均不能相等，若有一个相等了，则跳过该组合。否则看其中任意一个点的横坐标对应的集合中是否均包含另一个点的纵坐标，均包含的话，说明另两个顶点也是存在的，就可以计算矩形的面积了，更新结果 res，若最终 res 还是初始值，说明并没有能组成矩形，返回0即可，
//https://www.cnblogs.com/grandyang/p/12689148.html
// note: 3/23/21 need to check first two points are not in the same line.
class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> xToY = new HashMap<>();
        for (int[] p : points) {
            xToY.putIfAbsent(p[0], new HashSet<>());
            xToY.get(p[0]).add(p[1]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] pos1 = points[i];
                int[] pos3 = points[j];
                if (pos1[0] == pos3[0] || pos1[1] == pos3[1] ) {
                    continue;
                }
                // int[] pos2 = new int[]{pos1[0], pos3[1]};
                // int[] pos4 = new int[]{pos3[0], pos1[1]};
                if (xToY.get(pos1[0]).contains(pos3[1]) && xToY.get(pos3[0]).contains(pos1[1])) {
                    // System.out.println("test" + res + " " + i + " " + j);
                    res = Math.min(res, Math.abs(pos1[0] - pos3[0]) * Math.abs(pos1[1] - pos3[1]));
                }
                // System.out.println(res + " " + i + " " + j);
            }
        }
        return res == Integer.MAX_VALUE ? 0: res; 
    }
}