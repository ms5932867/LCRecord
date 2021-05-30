// https://www.youtube.com/watch?v=7FPL7nAi9aM
// Greatest common divisor
// 从p1 出发，检测后面每一个点和p1 形成的斜率： 经过同一个点， 且斜率相等的直线唯一
class Solution {
    public int maxPoints(int[][] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        Map<String, Integer> slopeCnt = new HashMap<>();
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            slopeCnt = new HashMap<>();
            int[] p1 = points[i];
            int p1Dup = 0;
            for(int j = i + 1; j < points.length; j++) {
                int[] p2 = points[j];
                if (Arrays.equals(p1, p2)) {
                    p1Dup++;
                } else {
                    String slope = getSlope(p1, p2);
                    slopeCnt.putIfAbsent(slope, 1);
                    slopeCnt.put(slope, slopeCnt.get(slope) + 1);
                }
            }
            max = Math.max(max, getMax(slopeCnt, p1Dup));

        }
        return max;
    }
    private String getSlope(int[] p1, int[] p2) {
        //slope = a/ b
        // a = p1[1] - p2[1]
        // b = p1[0] - p2[0]
        // get the Greatest common divisor: gcd
        // slope = a/ gcd + "/" + b/gcd
        String slope = "";
        int a = p1[1] - p2[1];
        int b = p1[0] - p2[0];
        if (a == 0) { // horizontal
            slope = "horizontal";
        } else if (b == 0) {
            slope = "vertical";
        } else {
            int gcd = getGcd(a, b);
            slope = a / gcd + "/" + b / gcd;
        }
        return slope;
    }

    private int getGcd(int a, int b) {
        if ( b % a == 0) {
            return a;
        }
        return getGcd(b % a, a);
    }

    private int getMax(Map<String, Integer> slopeCnt, int p1Dup) {
        int curMax = 0;
        for (String s: slopeCnt.keySet()) {
            curMax = Math.max(curMax, slopeCnt.get(s) + p1Dup);
        }
        return curMax;
    }

}