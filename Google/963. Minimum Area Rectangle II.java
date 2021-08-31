import java.util.Map;
// https://www.cnblogs.com/grandyang/p/14103117.html
/**
 * 矩形的两条对角线长度是相等的，而且相交于矩形的中心，这个中心可以通过两个对顶点的坐标求出来。
 * 只要找到了两组对顶点，它们的中心重合，并且表示的对角线长度相等，则一定可以组成矩形。
 * 基于这种思想，可以遍历任意两个顶点，求出它们之间的距离，和中心点的坐标，
 * 将这两个信息组成一个字符串，建立和顶点在数组中位置之间的映射，这样能组成矩形的点就被归类到一起了。
 * 接下来就是遍历这个 HashMap 了，只能取出两组顶点及更多的地方，开始遍历，分别通过顶点的坐标算出两条边的长度，
 * 然后相乘用来更新结果 res 即可，
 */
class Solution {
    // Pair of two point which can be the diagonal
    public class Pair{
        int idx1;
        int idx2;
        Pair(int idx1, int idx2) {
            this.idx1 = idx1;
            this.idx2 = idx2;
        }
    }
    public double minAreaFreeRect(int[][] points) {
        double minRes = Double.MAX_VALUE;
        Map<String, List<Pair>> diagonals = buildDiagonalMap(points);
        for (String s: diagonals.keySet()) {
            List<Pair> pairs= diagonals.get(s);
            for (int i = 0; i < pairs.size(); i++) {
                for (int j = i + 1; j < pairs.size(); j++) {
                    int[] p1 = points[pairs.get(i).idx1];
                    int[] p2 = points[pairs.get(j).idx1];
                    int[] p3 = points[pairs.get(j).idx2];
                    // System.out.println(pairs.get(i).idx1 + " " + pairs.get(i).idx2 + " " + pairs.get(j).idx1);
                    minRes = Math.min(minRes, getArea(p1,p2,p3));
                }
            }
        }
        return minRes == Double.MAX_VALUE ? 0 : minRes;
    }
    private Map<String, List<Pair>> buildDiagonalMap(int[][] points) {
        Map<String, List<Pair>> diagonals = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                String key = String.valueOf(getDist(points[i], points[j])) + "_" + getCenter(points[i], points[j]);
                diagonals.putIfAbsent(key, new ArrayList<>());
                diagonals.get(key).add(new Pair(i, j));
            }
        }
        return diagonals;
    }
    private double getDist(int[] p1, int[] p2) {
        return Math.sqrt((Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2)));
    }
    private String getCenter(int[] p1, int[] p2) {
        return String.valueOf(p1[0] + p2[0]) + "_" + String.valueOf(p1[1] + p2[1]);
    }
    private double getArea(int[] p1, int[] p2, int[] p3) {
        double dist1 = getDist(p1, p2);
        double dist2 = getDist(p1, p3);
        // System.out.println("dist1=" + dist1 + " dist2="+dist2);
        return dist1 * dist2;
    }
}