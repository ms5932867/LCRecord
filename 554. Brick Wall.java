import java.util.Map;
class Solution {
    
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }
        Map<Integer, Integer> preSumCnt = new HashMap<>();
        int row = wall.size();
        int maxCnt = 0;
        for (List<Integer> w : wall) {
            int tmpPreSum = 0;
            for (int i = 0; i < w.size() - 1; i++) {
                tmpPreSum += w.get(i);
                preSumCnt.putIfAbsent(tmpPreSum, 0);
                preSumCnt.put(tmpPreSum, preSumCnt.get(tmpPreSum) + 1);
                maxCnt =  Math.max(maxCnt, preSumCnt.get(tmpPreSum));
            }
        }
        return row - maxCnt;
    }
}