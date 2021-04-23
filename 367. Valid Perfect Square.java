class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }
        int s = 1;
        int e = num / 2;
        while (s + 1 < e) {
            int m = s + (e - s) / 2;
            if (num / m == m && num % m == 0) {
                return true;
            } else if (num / m < m) {
                e = m;
            } else {
                s = m;
            }
        }

        if ((num / s == s && num % s == 0)|| (num / e == e && num % e == 0)) {
            return true;
        }
        return false;
    }
}