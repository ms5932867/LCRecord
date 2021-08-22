class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s = 1;
        int e = getMax(piles);
        while (s + 1 < e) {
            int m = s + (e - s) / 2;
            int hourNeeded = getHour(piles, m);
            if (hourNeeded > h) {
                s = m;
            } else {
                e = m;
            }
        }
        if (getHour(piles,s) <= h) {
            return s;
        }
        return e;
    }
    private int getMax(int[] piles) {
        int res = Integer.MIN_VALUE;
        for (int p : piles) {
            res = Math.max(res, p);
        }
        return res;
    } 
    private int getHour(int[] piles, int eat) {
        int hour = 0;
        for (int p : piles) {
            hour += (p / eat);
            if (p % eat != 0) {
                hour++;
            }
        }
        return hour;
    }
}
/**
 * max: the largest number of banana in a pile
 * min: 1
 */