// 遇到不相等的情况， 不能只考虑一种， 两种情况都要继续往下检测， 一个true就return true
// Solution 1: with helper function
class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            } 
            return helper(s, i, j - 1) || helper(s, i + 1, j);
        }
        return true;
    }
    private boolean helper(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}

// Solution 2
class Solution {
    int skip = 0;
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                if (skip == 1) {
                    return false;
                } else {
                    skip++;
                    return validPalindrome(s.substring(0, l) + s.substring(l + 1, s.length())) || validPalindrome(s.substring(0, r) + s.substring(r + 1, s.length()));
                }
            }
        }
        return true;
    }
}