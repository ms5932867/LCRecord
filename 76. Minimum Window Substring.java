import java.util.Map;
// 76. Minimum Window Substring
// Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".
// Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
// Example 1:
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Example 2:
// Input: s = "a", t = "a"
// Output: "a"
// Constraints:
// 1 <= s.length, t.length <= 10^5
// s and t consist of English letters.

// useful solution from laioffer
// https://www.youtube.com/watch?v=9qFR2WQGqkU

//v1:
class Solution {
    public String minWindow(String s, String t) {
        if (((s == null || s.length() == 0) && (t != null || t.length() != 0)) || t.length() > s.length()) {
            return "";
        }
        if (s.equals(t)) {
            return s;
        }
        Map<Character, Integer> tCnt = new HashMap<>(); 
        // count the number of chars in t that remains to be find in s
        // > 0  still some to find, < 0 already contains more than the t needs
        for (char c: t.toCharArray()) {
            tCnt.putIfAbsent(c, 0);
            tCnt.put(c, tCnt.get(c) + 1);
        }
        int remain = t.length(); // the number of chars in t that remains to be find in s
        int left = 0;
        String res = "";
        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            if (tCnt.containsKey(rc)) {
                tCnt.put(rc, tCnt.get(rc) - 1);
                if (tCnt.get(rc) >= 0) {
                    remain--;
                }
            }
            while (remain == 0) {
                if (res.length() == 0 || res.length() > right - left + 1) {
                    res = s.substring(left, right + 1);
                } 
                char lc = s.charAt(left);
                if (tCnt.containsKey(lc)) {
                    tCnt.put(lc, tCnt.get(lc) + 1);
                    if (tCnt.get(lc) > 0) {
                        remain++;
                    }
                }
                left++;
            }
        }
        return res;
    }
}

// v2
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> tCnt = new HashMap<>();
        // char and the number of the char need to be matched
        for (char c : t.toCharArray()) {
            tCnt.putIfAbsent(c, 0);
            tCnt.put(c, tCnt.get(c) + 1);
        }
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int remainToBeMatched = t.length();
        String res = "";
        for (int right = 0; right < s.length(); right++) {
            // System.out.println("Outsideleft =" + left + " right =" + right + " res=" + res);
            char curRight = s.charAt(right);
            if (!tCnt.containsKey(curRight)) {
                continue;
            }
            tCnt.put(curRight, tCnt.get(curRight) - 1);
            if (tCnt.get(curRight) >= 0) {
                remainToBeMatched--;  
            }
            

            while (remainToBeMatched == 0) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);
                    // System.out.println("left =" + left + " right =" + right + " res=" + res);
                }

                char curLeft = s.charAt(left);
                if (!tCnt.containsKey(curLeft)) {
                    left++;
                    continue;
                }

                tCnt.put(curLeft, tCnt.get(curLeft) + 1);
                if (tCnt.get(curLeft) > 0) {
                    remainToBeMatched++;
                }
                
                left++;
                
            }

        }
        return res;
    }
}
