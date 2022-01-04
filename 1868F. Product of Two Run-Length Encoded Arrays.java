class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while (i < encoded1.length && j < encoded2.length) {
            int curVal = encoded1[i][0] * encoded2[j][0];
            int curCnt = Math.min(encoded1[i][1], encoded2[j][1]);
            List<Integer> cur = new ArrayList<>();
            cur.add(curVal);
            if (res.size() == 0 || res.get(res.size() - 1).get(0) != curVal) {
                cur.add(curCnt);

            } else {
                int realCnt = curCnt + res.get(res.size() - 1).get(1);
                res.remove(res.size() - 1);
                cur.add(realCnt);
            }
            res.add(cur);
            if (encoded1[i][1] == encoded2[j][1]) {
                i++;
                j++;
            } else if (encoded1[i][1] > encoded2[j][1]) {
                encoded1[i][1] = encoded1[i][1] - encoded2[j][1];
                j++;
            } else {
                encoded2[j][1] = encoded2[j][1] - encoded1[i][1];
                i++; 
            }
        }
        return res;
    }
}