import java.util.Map;
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int sum = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> distCnt = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                double dist = Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2);
                distCnt.put(dist, distCnt.getOrDefault(dist, 0) + 1);
            }
            for (double dist : distCnt.keySet()) {
                if (distCnt.get(dist) > 1) {
                    sum += distCnt.get(dist) * (distCnt.get(dist) - 1)  ;
                }
            }
            distCnt.clear();
        }
        
       return sum; 
    }
}