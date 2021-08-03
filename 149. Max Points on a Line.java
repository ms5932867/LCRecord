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


//version 2
class Solution {
    public int maxPoints(int[][] points) {
        if (points == null ) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int max = 0;
        Map<String, Integer> slopeCnt = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] start = points[i];
            int curMax = 0;// not include start 
            int samePoint = 1;
            slopeCnt = new HashMap<>();

            for (int j = i + 1; j < points.length; j++) {
                int[] end = points[j];
                if (samePoint(start, end)) {
                    samePoint++;
                    continue;
                }
                String slope = getSlope(start, end);
                curMax = updateCurMax(slope, curMax, slopeCnt);

            }
            curMax = curMax + samePoint;
            max = Math.max(curMax, max);
        }
        return max;
    }
    private boolean samePoint(int[] s, int[] e) {
        return s[0] == e[0] && s[1] == e[1];
    }
    private String getSlope(int[] s, int[] e) { //y /x
        int y = e[1] - s[1];
        int x = e[0] - s[0];
        if (y == 0) { //horizontal
            return "h";
        }
        if (x == 0) { //vertical
            return "v";
        }
        int gcd = getGcd(Math.abs(x), Math.abs(y));
        
        if (y * x > 0) {
            return String.valueOf(Math.abs(y)/gcd) + "/" + String.valueOf(Math.abs(x)/gcd);
        } 
        return "-" + String.valueOf(Math.abs(y)/gcd) + "/" + String.valueOf(Math.abs(x)/gcd);
    }
    private int getGcd(int a, int b) {
        if (a < b) {
            return getGcd(b, a);
        }
        if (a % b == 0) {
            return b;
        }
        
        return getGcd(b, a % b);
    }
    private int updateCurMax(String slope, int curMax, Map<String, Integer> slopeCnt) {
        slopeCnt.putIfAbsent(slope, 0);
        slopeCnt.put(slope, slopeCnt.get(slope) + 1);
        return Math.max(curMax, slopeCnt.get(slope));
        
    }
}