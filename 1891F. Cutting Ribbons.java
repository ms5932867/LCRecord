class Solution {
    public int maxLength(int[] ribbons, int k) {
        long sum  = 0; // use long for sum!!!
        int s = 1; // start from 1 to avoid divide by 0
        int e = Integer.MIN_VALUE;
        
        for (int r: ribbons) {
            e = Math.max(e, r); // use max vlaue as largest value 
            sum += r;
        }
        
        while (s + 1 <  e) {
            int m = s + (e - s) / 2;
            if (canGetK(ribbons, m, k, sum)) {
                s = m;
            } else {
                e = m;
            }
        }
        if (canGetK(ribbons, e, k, sum)) {
            return e;
        } 
        if (canGetK(ribbons, s, k, sum)) {
            return s;
        }
        return 0;

    }
    private boolean canGetK(int[] ribbons, int length, int k, long sum) {
        if (sum / length < k) {
            return false;
        }
        int cnt = 0;
        for (int r: ribbons) {
            cnt += r / length;
        }

        return cnt >= k;
    }
}