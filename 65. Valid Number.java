//https://www.youtube.com/watch?v=QXNvEz-GwQ4
class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int i = 0;
        // white space
        while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        // + -
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }
        // hasDigitBeforeDot
        boolean hasDigitBeforeDot = false;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            if (!hasDigitBeforeDot) {
                hasDigitBeforeDot = true;
            }
            i++;
        }
        // dot
        boolean hasDot = false;
        if (i < s.length() && s.charAt(i) == '.') {
            hasDot = true;
            i++;
        }
        // hasDigitAfterDot
        boolean hasDigitAfterDot = false;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            if (!hasDigitAfterDot) {
                hasDigitAfterDot = true;
            }
            
            i++;
        }
        // e or E
        boolean hasE = false;
        if (i < s.length() && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            hasE = true;
            i++;
        }
        // + -
        boolean hasSignAfterE = false;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            hasSignAfterE = true;
            i++;
        }
        // digit after E
        boolean hasDigitAfterE = false;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            if (!hasDigitAfterE) {
                hasDigitAfterE = true;
            }
            i++;
        }
        // white space
        while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        // check
        boolean finishScan = (i == s.length());
        return finishScan && (hasDigitBeforeDot || hasDigitAfterDot) && ((!hasE && !hasSignAfterE) || (hasE && hasDigitAfterE));


    }
}