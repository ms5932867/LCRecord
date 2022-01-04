// binary search, // last day may not have a full capacity
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;
        for (int w: weights) {
            end += w;
            start = Math.max(start, w);
        }
        while (start + 1 <  end) {
            int m = start + (end - start) / 2;
            if (helper(weights, days, m)) {
                end = m;
            } else {
                start = m + 1;
            }
        } 
        if (helper(weights, days, start)) {
            return start;
        }
        return end;
    }
    private boolean helper(int[] weights, int days, int capacity) {
        int cntDays = 0;
        int cur = 0;
        for (int w: weights) {
            cur += w;
            if (cur > capacity) {
                cntDays++;
                if (cntDays > days) {
                    return false;
                }
                cur = w;  
            }
        }
        // last day may not have a full capacity
        if (cur != 0) {
            cntDays++;
        }
        // System.out.println("capacity=" + capacity + " cntDays=" + cntDays + " days=" + days);
        if (cntDays > days) {
            return false;
        }
        return true;
    }
}