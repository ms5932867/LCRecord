class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char ci = Character.toLowerCase(s.charAt(i));
            char cj = Character.toLowerCase(s.charAt(j));
            if (!Character.isLetterOrDigit(ci)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(cj)) {
                j--;
                continue;
            }
            if (ci == cj) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}

/*
Character.toLowerCase('A') → 'a'
Character.toLowerCase('b') → 'b'
Character.toLowerCase('1') → '1'  // 不变
Character.toLowerCase('#') → '#'  // 不变
*/
