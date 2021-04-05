class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int s = 1;
        int e = num /2;
        while (s + 1 < e) {
            int m = s + (e - s) / 2;
            int tmp = num / m;
            int remain = num % m;
            if (tmp == m && remain == 0) {
                return true;
            } else if (tmp < m) {
                e = m;
            } else {
                s = m;
            }
        } 
        if (s * s == num || e * e == num) {
            return true;
        }
        return false;
    }
}