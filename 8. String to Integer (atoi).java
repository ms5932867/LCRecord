class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // leading space
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i == s.length()) {
            return 0;
        }
        
        // check +/-
        boolean isPositive = true;
        if (s.charAt(i) == '-') {
            isPositive = false;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        } else if (Character.isLetter(s.charAt(i)) ) {
            return 0;
        }
        
        // build number
        long num = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            if (isPositive && num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (!isPositive && num * (-1) < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        if (!isPositive) {
            num = num * (long)(-1);
        }
        return (int)num;
    }
}